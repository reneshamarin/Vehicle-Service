package com.tutycarcare.api.rest.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Custom Authentication Entry Point for the request which needs to be authenticated
 * 
 * @author Coda Global Team
 *
 */
@Component
public class CustomAuthenticationEntryPoint  implements AuthenticationEntryPoint{

	//private static final Logger LOGGER = LogManager.getLogger();
	/* (non-Javadoc)
	 * @see org.springframework.security.web.AuthenticationEntryPoint#commence(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.AuthenticationException)
	 *
	 * This method is invoked internally when authentication fails
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		//LOGGER.entry();
		if(request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.toString())){
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		} else {
			response.setContentType(MediaType.APPLICATION_JSON);
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("{ \"error\": \"" + authException.getMessage() + "\" }");	
		}
		//LOGGER.exit();
	}

}
