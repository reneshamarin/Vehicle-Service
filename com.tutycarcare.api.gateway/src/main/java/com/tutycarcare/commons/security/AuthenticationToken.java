package com.tutycarcare.commons.security;

import java.util.Date;

/**
 * Authentication token bean
 * @author Coda Global Team
 *
 */
public class AuthenticationToken {
	 
	private String accessToken;
	private String refreshToken;
	private Date expiresIn;
	private String userId;

	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public Date getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Date expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "AuthenticationToken [accessToken=" + accessToken + ", refreshToken=" + refreshToken + ", expiresIn="
				+ expiresIn + ", userId=" + userId + "]";
	}
	
}
