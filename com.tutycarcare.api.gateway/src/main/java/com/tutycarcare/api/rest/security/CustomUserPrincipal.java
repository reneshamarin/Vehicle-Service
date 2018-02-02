package com.tutycarcare.api.rest.security;

import java.security.Principal;
import java.util.List;

public class CustomUserPrincipal implements Principal {
	private List<String> roles;

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String getName() {
		return "renesha";
	}
}