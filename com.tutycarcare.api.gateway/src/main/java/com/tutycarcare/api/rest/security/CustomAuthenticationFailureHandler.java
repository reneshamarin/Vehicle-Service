package com.tutycarcare.api.rest.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * Contains the methods for Custom Authentication
 * 
 * @author Coda Global Team
 *
 */
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	//private static final Logger LOGGER = LogManager.getLogger();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.
	 * AuthenticationFailureHandler#onAuthenticationFailure(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.AuthenticationException)
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		//LOGGER.entry();
		if (request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.toString())) {
			response.setStatus(HttpStatus.OK.value());
		} else {
			if (exception instanceof AuthenticationFailedException) {
				AuthenticationFailedException authFailedException = (AuthenticationFailedException) exception;
				response.setContentType(MediaType.APPLICATION_JSON);
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				String responseContent = "{" + "\"code\" : " + authFailedException.getCode() + ","
						+ "\"message\" : \"" + authFailedException.getMessage() + "\"" + "}";
				response.getWriter().write(responseContent);

			} else {
				response.setContentType(MediaType.APPLICATION_JSON);
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				// response.getOutputStream().println("{ \"error\": \"" +
				// authException.getMessage() + "\" }");
				response.getWriter().write("{ \"error\": \"" + exception.getMessage() + "\" }");
			}
		}

		//LOGGER.exit();

	}

}
