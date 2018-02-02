package com.tutycarcare.api.rest.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomAuthenticationToken  extends UsernamePasswordAuthenticationToken {


	public CustomAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);
		this.accessToken = (String) credentials;
	}
	private static final long serialVersionUID = 1L;
	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
