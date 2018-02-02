package com.tutycarcare.api.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tutycarcare.api.rest.constants.FilterConstants;

/**
 * Filter that returns a response with headers that allows for Cross-Origin
 * Requests (CORs) to be performed against the platform API.
 */
@Provider
public class CustomResponseCorsFilter implements ContainerResponseFilter {
	private static final Logger LOGGER = LogManager.getLogger();

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		LOGGER.entry();
		responseContext.getHeaders().add(FilterConstants.ALLOW_ORIGIN, FilterConstants.ALLOW_ORIGIN_VALUE);
		responseContext.getHeaders().add(FilterConstants.ALLOW_HEADERS, FilterConstants.ALLOW_HEADERS_VALUE);
		responseContext.getHeaders().add(FilterConstants.ALLOW_CREDENTIALS, FilterConstants.ALLOW_CREDENTIALS_VALUE);
		responseContext.getHeaders().add(FilterConstants.ALLOW_METHODS, FilterConstants.ALLOW_METHODS_VALUE);
		LOGGER.exit();
	}
}