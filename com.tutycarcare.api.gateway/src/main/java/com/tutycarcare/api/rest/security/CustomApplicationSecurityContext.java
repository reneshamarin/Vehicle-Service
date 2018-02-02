package com.tutycarcare.api.rest.security;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;


public class CustomApplicationSecurityContext implements SecurityContext {
	private CustomUserPrincipal user;
	private String scheme = "https";
	
	public CustomApplicationSecurityContext(CustomUserPrincipal user) {
		this.user = user;
	}
	
	@Override
	public Principal getUserPrincipal() {
		// TODO Auto-generated method stub
		return new CustomUserPrincipal();
	}

	@Override
	public boolean isUserInRole(String role) {
		if (user.getRoles() != null) {
			return user.getRoles().contains(role);
		}
		return false;
	}

	@Override
	public boolean isSecure() {
		return "https".equals(this.scheme);
	}

	@Override
	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}

}
