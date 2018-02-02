package com.tutycarcare.api.rest.security;

import java.util.ResourceBundle;

import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.toothcloud.commons.exception.BusinessException;
import com.tutycarcare.api.rest.constants.ServiceResourceConstants;

/**
 * Custom Authentication Provider which validates and parses JWT to retrieve
 * user information
 * 
 * @author Coda Global Team
 *
 */
@Provider
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	private static final ResourceBundle BUNDLE = ResourceBundle
			.getBundle(ServiceResourceConstants.AUTHENTICATION_BUNDLE);

	private static final Logger LOGGER= LogManager.getLogger();
	
	@Override
	public boolean supports(Class<?> authentication) {

		return CustomAuthenticationToken.class.isAssignableFrom(authentication);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.authentication.dao.
	 * AbstractUserDetailsAuthenticationProvider#additionalAuthenticationChecks(
	 * org.springframework.security.core.userdetails.UserDetails,
	 * org.springframework.security.authentication.
	 * UsernamePasswordAuthenticationToken)
	 */
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.authentication.dao.
	 * AbstractUserDetailsAuthenticationProvider#retrieveUser(java.lang.String,
	 * org.springframework.security.authentication.
	 * UsernamePasswordAuthenticationToken)
	 */
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		String userId = (String) authentication.getPrincipal();
		String token = (String) authentication.getCredentials();
		String userType = TokenHandler.parseAccessTokenToGetStringValue(token, TokenConstants.USER_TYPE.toString());
		return new AuthenticatedUser(userId, userType);


	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.authentication.dao.
	 * AbstractUserDetailsAuthenticationProvider#authenticate(org.
	 * springframework.security.core.Authentication)
	 */
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException, BusinessException {
		CustomAuthenticationToken authenticationToken = (CustomAuthenticationToken) authentication;

		LOGGER.debug(authenticationToken.getAccessToken());
		String token = authenticationToken.getAccessToken();
		String userId = null;
		try {
			userId = TokenHandler.parseAccessToken(token, false);
		} catch (BusinessException e) {
			throw new AuthenticationFailedException(e.getCode(), e.getMessage());
		}

		if (userId == null || "".equals(userId)) {
			throw new AuthenticationCredentialsNotFoundException(BUNDLE.getString("TCRSPMAAUTH3004E"));
		}

		authenticationToken.setDetails(userId);
		return super.authenticate(new CustomAuthenticationToken(userId, token));
	}

}
