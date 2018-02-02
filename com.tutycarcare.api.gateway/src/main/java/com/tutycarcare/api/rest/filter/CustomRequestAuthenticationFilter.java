package com.tutycarcare.api.rest.filter;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.toothcloud.commons.exception.BusinessException;
import com.tutycarcare.api.rest.constants.FilterConstants;
import com.tutycarcare.api.rest.constants.ServiceResourceConstants;
import com.tutycarcare.api.rest.security.AuthenticatedUser;
import com.tutycarcare.api.rest.security.CustomAuthenticationToken;
import com.tutycarcare.commons.security.CustomAuthenticatedUser;

@Provider
public class CustomRequestAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	private static final Logger LOGGER = LogManager.getLogger();
	private static final ResourceBundle BUNDLE = ResourceBundle
			.getBundle(ServiceResourceConstants.AUTHENTICATION_BUNDLE);

	@Autowired
	ApplicationContext applicationContext;

	public CustomRequestAuthenticationFilter() {
		super("/**");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.
	 * AbstractAuthenticationProcessingFilter#requiresAuthentication(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
		if (request.getMethod().equals(HttpMethod.OPTIONS.toString()))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.
	 * AbstractAuthenticationProcessingFilter#attemptAuthentication(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, BusinessException {
		LOGGER.entry();

		LOGGER.debug(request.getMethod());

		if (request.getMethod().equals(HttpMethod.OPTIONS.toString())) {
			Authentication authentication = new CustomAuthenticationToken(null, null);
			authentication.setAuthenticated(true);
			return authentication;
		}

		String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (authorizationHeader == null || !authorizationHeader.startsWith(FilterConstants.BEARER)) {
			// throw new BusinessException(code, message)
			LOGGER.error(BUNDLE.getString("TCRSPMAAUTH3005E"));
			throw new AuthenticationCredentialsNotFoundException(BUNDLE.getString("TCRSPMAAUTH3005E"));
		}
		String authToken = authorizationHeader.substring(FilterConstants.BEARER.length()).trim();
		if (authToken == null) {
			LOGGER.error(BUNDLE.getString("TCRSPMAAUTH3001E"));
			throw new AuthenticationCredentialsNotFoundException(BUNDLE.getString("TCRSPMAAUTH3001E"));
		}
		CustomAuthenticationToken authentication = new CustomAuthenticationToken(null, authToken);

		LOGGER.exit();
		return getAuthenticationManager().authenticate(authentication);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.
	 * AbstractAuthenticationProcessingFilter#successfulAuthentication(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * javax.servlet.FilterChain, org.springframework.security.core.Authentication)
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		// request.getServletContext().setAttribute(ParameterConstants.USER,
		// authResult.getPrincipal());
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) authResult.getPrincipal();
		CustomAuthenticatedUser customAuthenticatedUser = applicationContext.getBean(CustomAuthenticatedUser.class);

		if (customAuthenticatedUser != null) {
			customAuthenticatedUser.setUserId(authenticatedUser.getUserId());
			customAuthenticatedUser.setUserType(authenticatedUser.getUserType());
		}

		chain.doFilter(request, response); // to proceed with the filter chain
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.
	 * AbstractAuthenticationProcessingFilter#unsuccessfulAuthentication(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.AuthenticationException)
	 */
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		LOGGER.entry();
		super.unsuccessfulAuthentication(request, response, authException);
		LOGGER.exit();
	}
}
