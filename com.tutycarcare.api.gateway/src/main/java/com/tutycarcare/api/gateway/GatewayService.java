package com.tutycarcare.api.gateway;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.toothcloud.commons.exception.SystemException;
import com.tutycarcare.api.rest.constants.ApplicationConstants;
import com.tutycarcare.api.rest.constants.FilterConstants;
import com.tutycarcare.api.rest.constants.ParameterConstants;
import com.tutycarcare.api.rest.security.TokenConstants;
import com.tutycarcare.api.rest.security.TokenHandler;
import com.tutycarcare.commons.security.CustomAuthenticatedUser;

@Component
@Path("/tutycarcare")
public class GatewayService {

	@Autowired
	CustomAuthenticatedUser user;

	@Autowired
	ServiceDiscovery serviceDiscovery;

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * To check if PMA Gateway is up
	 * 
	 * @return
	 */
	@GET
	@Path("/health_checkup")
	@Produces(MediaType.APPLICATION_JSON)
	public String healthCheckup() {
		return new String(ApplicationConstants.SUCCESS);
	}

	@GET
	@Path("/{path}/{path2}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@Context HttpHeaders headers, @Context HttpServletRequest request,
			@PathParam("path") String path, @PathParam("path2") String path2) {
		LOGGER.entry();
		Timestamp startTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		Client client = ClientBuilder.newClient();
		String url = serviceDiscovery.getServiceURL(path);
		WebTarget webTarget = client.target(url + "/" + path + "/" + path2 + "?" + request.getQueryString());
		LOGGER.debug(webTarget.getUri());
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		for (String headerName : headers.getRequestHeaders().keySet()) {
			LOGGER.debug(headerName);
			if (headerName.equalsIgnoreCase(ParameterConstants.HEADER_NODE_ID)
					|| headerName.equalsIgnoreCase(ParameterConstants.HEADER_ROLE_ID))
				invocationBuilder = invocationBuilder.header(headerName, headers.getRequestHeader(headerName).get(0));
		}
		if (user != null) {
			invocationBuilder.header(ParameterConstants.HEADER_USER_ID, user.getUserId());
			invocationBuilder.header(ParameterConstants.HEADER_USER_TYPE, user.getUserType());
			invocationBuilder = getLocationForLogin(headers, invocationBuilder);
		}
		Response response = invocationBuilder.get();
		Timestamp endTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		
		if("node".equalsIgnoreCase(path)){
			long diff = (endTime.getTime() - startTime.getTime());
			LOGGER.debug(request.getPathInfo() + " --- " + diff);
		}
		LOGGER.exit();
		return response;
	}

	@POST
	@Path("/{path}/{path2}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(@Context HttpHeaders headers, @Context HttpServletRequest request,
			@PathParam("path") String path, @PathParam("path2") String path2, String body) {
		LOGGER.entry();
		Timestamp startTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		Client client = ClientBuilder.newClient();
		String url = serviceDiscovery.getServiceURL(path);
		WebTarget webTarget = client.target(url + "/" + path + "/" + path2 + "?" + request.getQueryString());
		LOGGER.debug(webTarget.getUri());
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		for (String headerName : headers.getRequestHeaders().keySet()) {
			LOGGER.debug(headerName);
			if (headerName.equalsIgnoreCase(ParameterConstants.HEADER_NODE_ID)
					|| headerName.equalsIgnoreCase(ParameterConstants.HEADER_ROLE_ID))
				invocationBuilder = invocationBuilder.header(headerName, headers.getRequestHeader(headerName).get(0));
		}
		if (user != null) {
			invocationBuilder.header(ParameterConstants.HEADER_USER_ID, user.getUserId());
			invocationBuilder.header(ParameterConstants.HEADER_USER_TYPE, user.getUserType());
			invocationBuilder = getLocationForLogin(headers, invocationBuilder);
		}
		Response response = invocationBuilder.post(Entity.json(body));

		Timestamp endTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		
		if("node".equalsIgnoreCase(path)){
			long diff = (endTime.getTime() - startTime.getTime());
			LOGGER.debug(request.getPathInfo() + " --- " + diff);
		}
		LOGGER.exit();
		return response;
	}

	@POST
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{path}/{path2}")
	public Response updateProfilePhoto(@Context HttpHeaders headers, @Context HttpServletRequest request,
			@PathParam("path") String path, @PathParam("path2") String path2,
			@FormDataParam(ParameterConstants.IMAGE) InputStream fileInputStream,
			@FormDataParam(ParameterConstants.IMAGE) FormDataContentDisposition fileFormDataContentDisposition,
			@HeaderParam(ParameterConstants.HEADER_USER_ID) int userId, FormDataMultiPart multiPart)
			throws SystemException {
		LOGGER.entry(fileInputStream, fileFormDataContentDisposition, userId);
		Client client = ClientBuilder.newClient();
		String url = serviceDiscovery.getServiceURL(path);
		WebTarget webTarget = client.target(url + "/" + path + "/" + path2 + "?" + request.getQueryString())
				.register(MultiPartFeature.class);
		LOGGER.debug(webTarget.getUri());
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		for (String headerName : headers.getRequestHeaders().keySet()) {
			LOGGER.debug(headerName);
			if (headerName.equalsIgnoreCase(ParameterConstants.HEADER_NODE_ID)
					|| headerName.equalsIgnoreCase(ParameterConstants.HEADER_ROLE_ID))
				invocationBuilder = invocationBuilder.header(headerName, headers.getRequestHeader(headerName).get(0));
		}
		if (user != null) {
			invocationBuilder.header(ParameterConstants.HEADER_USER_ID, user.getUserId());
			invocationBuilder.header(ParameterConstants.HEADER_USER_TYPE, user.getUserType());
			invocationBuilder = getLocationForLogin(headers, invocationBuilder);
		}
		Response response = invocationBuilder.post(Entity.entity(multiPart, MediaType.MULTIPART_FORM_DATA));
		LOGGER.exit(response);
		return response;
	}

	@PUT
	@Path("/{path}/{path2}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response put(@Context HttpHeaders headers, @Context HttpServletRequest request,
			@PathParam("path") String path, @PathParam("path2") String path2, String body) {
		LOGGER.entry();
		Client client = ClientBuilder.newClient();
		String url = serviceDiscovery.getServiceURL(path);
		WebTarget webTarget = client.target(url + "/" + path + "/" + path2 + "?" + request.getQueryString());
		LOGGER.debug(webTarget.getUri());
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		for (String headerName : headers.getRequestHeaders().keySet()) {
			LOGGER.debug(headerName);
			if (headerName.equalsIgnoreCase(ParameterConstants.HEADER_NODE_ID)
					|| headerName.equalsIgnoreCase(ParameterConstants.HEADER_ROLE_ID))
				invocationBuilder = invocationBuilder.header(headerName, headers.getRequestHeader(headerName).get(0));
		}
		if (user != null) {
			invocationBuilder.header(ParameterConstants.HEADER_USER_ID, user.getUserId());
			invocationBuilder.header(ParameterConstants.HEADER_USER_TYPE, user.getUserType());
			invocationBuilder = getLocationForLogin(headers, invocationBuilder);
		}
		Response response = invocationBuilder.put(Entity.json(body));
		LOGGER.exit();
		return response;
	}

	@DELETE
	@Path("/{path}/{path2}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@Context HttpHeaders headers, @Context HttpServletRequest request,
			@PathParam("path") String path, @PathParam("path2") String path2) {
		LOGGER.entry();
		Client client = ClientBuilder.newClient();
		String url = serviceDiscovery.getServiceURL(path);
		WebTarget webTarget = client.target(url + "/" + path + "/" + path2 + "?" + request.getQueryString());
		LOGGER.debug(webTarget.getUri());
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		for (String headerName : headers.getRequestHeaders().keySet()) {
			LOGGER.debug(headerName);
			if (headerName.equalsIgnoreCase(ParameterConstants.HEADER_NODE_ID)
					|| headerName.equalsIgnoreCase(ParameterConstants.HEADER_ROLE_ID))
				invocationBuilder = invocationBuilder.header(headerName, headers.getRequestHeader(headerName).get(0));
		}
		if (user != null) {
			invocationBuilder.header(ParameterConstants.HEADER_USER_ID, user.getUserId());
			invocationBuilder.header(ParameterConstants.HEADER_USER_TYPE, user.getUserType());

			invocationBuilder = getLocationForLogin(headers, invocationBuilder);
		}
		Response response = invocationBuilder.delete();
		LOGGER.exit();
		return response;
	}

	/**
	 * Gets node id for location login
	 * 
	 * @param headers
	 * @param invocationBuilder
	 * @return
	 */
	private Builder getLocationForLogin(HttpHeaders headers, Builder invocationBuilder) {
		LOGGER.entry();
		for (String headerName : headers.getRequestHeaders().keySet()) {
			LOGGER.debug(headerName);
			if (headerName.equalsIgnoreCase(HttpHeaders.AUTHORIZATION)) {
				String authHeader = headers.getRequestHeader(headerName).get(0);
				String authToken = authHeader.substring(FilterConstants.BEARER.length()).trim();
				int nodeId = TokenHandler.parseAccessTokenToGetIntValue(authToken, TokenConstants.NODE_ID);
				if (nodeId != 0 && (headers.getRequestHeader(ParameterConstants.HEADER_NODE_ID) == null
						|| headers.getRequestHeader(ParameterConstants.HEADER_NODE_ID).isEmpty())) {
					invocationBuilder = invocationBuilder.header(ParameterConstants.HEADER_NODE_ID, nodeId);
				}
				String randomKey = TokenHandler.parseAccessTokenToGetStringValue(authToken,
						TokenConstants.CODE.toString());
				invocationBuilder = invocationBuilder.header(ParameterConstants.HEADER_ACTIVITY_ID, randomKey);
			}
		}
		return invocationBuilder;
	}
}
