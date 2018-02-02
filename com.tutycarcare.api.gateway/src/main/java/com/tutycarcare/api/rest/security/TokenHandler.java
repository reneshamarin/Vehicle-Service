package com.tutycarcare.api.rest.security;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.toothcloud.commons.exception.BusinessException;
import com.toothcloud.commons.exception.SystemException;
import com.tutycarcare.commons.exception.BusinessErrorCode;
import com.tutycarcare.commons.security.AuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class TokenHandler {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(TokenConstants.AUTHENTICATION_BUNDLE);

	private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

	private static final String secretKey = "MIIBOwIBAAJBALouMX1pk1W9ruf7bpvOwbun5D+OTLWAzX2ub9Bxacir5uPR779A0luRhWcUMcllMCBCYMkTzNyotB36gk70QEkCAwEAAQJAHRq9h9JqQtwNLJyklNzEclZzmu/e0/zXos8TEa25ELJyMQFOiG61VGsQS1HOTCiEnk/9RuhWaytjcE7ha9T6gQIhAO9Su2ZrfvmG9qB1mAY8GJzAghxwzm6mAMGE9RQhshOxAiEAxydzwKG2jvag7G4YwNR4D14i+qIlACv3UZV9bbWOlBkCIQDdME6pk3KQdu+cT/MI2CQ7RCU82fnBBEYwlYzZZWcrkQIhAJhcDGhAz4OMFw0KJZHQepF3OVd5mMkK2cjmjvDRx2RxAiA4DGr87QzQ6KC6ATd3GXB3rqa1mNjVNS+txYs+iVlJYw";
	private static final String tokenExpiry = "60";
	private static final String sessionExpiry = "120";

	/**
	 * Calculates the current time
	 * 
	 * @return Date
	 */
	private static Date getCurrentTime() {
		LOGGER.entry();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		Date currentTime = cal.getTime();

		LOGGER.exit(currentTime);
		return currentTime;
	}

	/**
	 * Calculates the token expiry time by adding the token expiry minutes to the
	 * current time
	 * 
	 * @return Date
	 */
	private static Date calculateTokenExpiryTime() {
		LOGGER.entry();
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.MINUTE, Integer.parseInt(tokenExpiry));
		Date tokenExpiryTime = cal.getTime();

		LOGGER.exit(tokenExpiryTime);
		return tokenExpiryTime;
	}

	/**
	 * Generates a refresh token containing the user ID
	 * 
	 * @param userId
	 * @return String - Refresh Token
	 */
	private static String generateRefreshToken(String userId) {
		LOGGER.entry();
		JwtBuilder builder = Jwts.builder().claim(TokenConstants.USER_ID, userId).signWith(signatureAlgorithm,
				secretKey);

		// Builds the JWT and serializes it to a compact, URL-safe string
		String refreshToken = builder.compact();
		LOGGER.debug(MessageFormat.format(BUNDLE.getString("TCSPAS1002D"), refreshToken));

		LOGGER.exit();
		return refreshToken;
	}

	/**
	 * Generates a access token containing the email, the ID and the token expiry
	 * time
	 * 
	 * @param email
	 * @param userId
	 * @param tokenExpiryTime
	 * @return String - Access Token
	 */
	private static String generateAccessToken(String email, String userId, Date tokenExpiryTime,
			Date tokenGenerationTime) {
		LOGGER.entry(email, userId);
		LOGGER.debug(secretKey);

		Claims claims = Jwts.claims();
		claims.put(TokenConstants.EMAIL, email);
		claims.put(TokenConstants.USER_ID, userId);
		claims.put(TokenConstants.EXPIRES_AT, tokenExpiryTime.getTime());
		claims.put(TokenConstants.GENERATED_AT, tokenGenerationTime.getTime());
		// building the jwt token
		JwtBuilder builder = Jwts.builder().setClaims(claims).signWith(signatureAlgorithm, secretKey);

		// Builds the JWT and serializes it to a compact, URL-safe string
		String accessToken = builder.compact();
		LOGGER.debug(MessageFormat.format(BUNDLE.getString("TCSPAS1001D"), accessToken));

		LOGGER.exit();
		return accessToken;
	}

	/**
	 * Creates an Authentication Token object containing access token, refresh token
	 * and token expiry time
	 * 
	 * @param email
	 * @param userId
	 * @return Authentication Token
	 */
	public static AuthenticationToken createJwtToken(String email, String userId)
			throws BusinessException, SystemException {
		LOGGER.entry(email, userId);
		LOGGER.debug(secretKey);
		Date tokenExpiryTime = calculateTokenExpiryTime();
		Date tokenGenerationTime = getCurrentTime();
		// generate the access and the refresh tokens
		String accessToken = generateAccessToken(email, userId, tokenExpiryTime, tokenGenerationTime);
		String refreshToken = generateRefreshToken(userId);

		// encode the generated tokens
		accessToken = encodeBase64(accessToken);
		refreshToken = encodeBase64(refreshToken);

		AuthenticationToken authToken = new AuthenticationToken();
		authToken.setAccessToken(accessToken);
		authToken.setExpiresIn(tokenExpiryTime);
		authToken.setRefreshToken(refreshToken);
		LOGGER.exit(authToken);
		return authToken;
	}

	/**
	 * Regenerates a new access token for the given old valid access token
	 * 
	 * @param accessToken
	 * @return AuthenticationToken
	 * @throws SystemException
	 */
	public static AuthenticationToken regenerateAccessToken(String accessToken, boolean refresh)
			throws BusinessException, SystemException {
		LOGGER.entry(accessToken);
		accessToken = decodeBase64(accessToken);
		String userId;
		String email;
		try {
			if (accessToken != null) {
				// This line will throw an exception if it is not a signed JWS.
				Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(accessToken).getBody();

				// Check if token has expired or not
				boolean tokenExpired = hasTokenExpired(
						Long.parseLong(claims.get(TokenConstants.EXPIRES_AT).toString()));
				if (tokenExpired && !refresh) {
					throw new BusinessException(BusinessErrorCode.TOKEN_EXPIRED, BUNDLE.getString("TCRSPMAAUTH3002E"));
				}

				userId = (String) claims.get(TokenConstants.USER_ID);
				email = (String) claims.get(TokenConstants.EMAIL);
			} else {
				LOGGER.error(BUNDLE.getString("TCRSPMAAUTH3006E"));
				throw new BusinessException(BusinessErrorCode.TOKEN_NOT_SET, BUNDLE.getString("TCRSPMAAUTH3006E"));
			}
		} catch (SignatureException e) {
			LOGGER.error(e.getMessage());
			throw new BusinessException(BusinessErrorCode.TOKEN_INVALID, e.getMessage());
		}

		Date tokenExpiryTime = calculateTokenExpiryTime();
		Date tokenGenerationTime = getCurrentTime();
		accessToken = generateAccessToken(email, userId, tokenExpiryTime, tokenGenerationTime);
		accessToken = encodeBase64(accessToken);
		AuthenticationToken authToken = new AuthenticationToken();
		authToken.setAccessToken(accessToken);
		authToken.setExpiresIn(tokenExpiryTime);

		LOGGER.exit(authToken);
		return authToken;
	}

	/**
	 * encode the token
	 * 
	 * @param token
	 * @return String
	 */
	private static String encodeBase64(String token) {
		return new String(Base64.encodeBase64(token.getBytes()));
	}

	/**
	 * decode the token
	 * 
	 * @param encodedToken
	 * @return String
	 */
	private static String decodeBase64(String encodedToken) {
		return new String(Base64.decodeBase64(encodedToken.getBytes()));
	}

	/**
	 * Checks if access token has expired or not
	 * 
	 * @param expirationTime
	 * @return boolean
	 */
	private static boolean hasTokenExpired(long expirationTime) {
		LOGGER.entry(expirationTime);
		long currentTime = new Date().getTime();
		boolean tokenExpired = true;
		if (currentTime < expirationTime) {
			tokenExpired = false;
		}
		LOGGER.exit(tokenExpired);
		return tokenExpired;
	}

	/**
	 * Checks if session has expired or not
	 * 
	 * @param tokenGenerationTime
	 * @return boolean
	 */
	private static boolean hasSessionExpired(Date tokenGenerationTime) {
		LOGGER.entry(tokenGenerationTime);

		boolean sessionExpired = false;

		Date currentTime = getCurrentTime();
		long currentTimeInMs = currentTime.getTime();
		long tokenGenTimeInMs = tokenGenerationTime.getTime();

		// convert session expiry minutes to milli seconds
		int sessionExpiryMs = Integer.parseInt(sessionExpiry) * 60 * 1000;

		// sessionTime.
		if (currentTimeInMs - tokenGenTimeInMs > sessionExpiryMs) {
			sessionExpired = true;
		}
		LOGGER.exit(sessionExpired);
		return sessionExpired;
	}

	/**
	 * Parses the access token and retrieves the user ID from the token
	 * 
	 * @param accessToken
	 * @return String - userId
	 * @throws BusinessException
	 */
	public static String parseAccessToken(String accessToken, boolean refresh) throws BusinessException {
		LOGGER.entry(accessToken, refresh);
		accessToken = decodeBase64(accessToken);
		String userId;
		try {
			if (accessToken != null) {
				// This line will throw an exception if it is not a signed JWS.
				Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(accessToken).getBody();

				Date tokenGenerationTime = new Date((long) claims.get(TokenConstants.GENERATED_AT));
				boolean sessionExpired = hasSessionExpired(tokenGenerationTime);
				if (sessionExpired) {
					throw new BusinessException(BusinessErrorCode.SESSION_EXPIRED,
							BUNDLE.getString("TCRSPMAAUTH3008E"));
				}
				long tokenExpiryTimeMs = (long) claims.get(TokenConstants.EXPIRES_AT);
				// Check if token has expired or not
				boolean tokenExpired = hasTokenExpired(tokenExpiryTimeMs);
				if (tokenExpired && !refresh) {
					// LOGGER.error(BUNDLE.getString("TCRSPMAAUTH3002E"));
					throw new BusinessException(BusinessErrorCode.TOKEN_EXPIRED, BUNDLE.getString("TCRSPMAAUTH3002E"));
				}

				userId = (String) claims.get(TokenConstants.USER_ID);
			} else {
				throw new BusinessException(BusinessErrorCode.TOKEN_NOT_SET, BUNDLE.getString("TCRSPMAAUTH3006E")); // TODO
			}
		} catch (ExpiredJwtException e) {

			LOGGER.error(e.getMessage());
			throw new BusinessException(BusinessErrorCode.TOKEN_EXPIRED, e.getMessage());

		} catch (SignatureException e) {
			LOGGER.error(e.getMessage());
			throw new BusinessException(BusinessErrorCode.TOKEN_INVALID, e.getMessage());
		} catch (MalformedJwtException e) {
			LOGGER.error(e.getMessage());
			throw new BusinessException(BusinessErrorCode.TOKEN_INVALID, e.getMessage());
		}
		LOGGER.exit(userId);
		return userId;
	}

	/**
	 * Parses the refresh token and returns the id(user id or member id) set in the
	 * token claims
	 * 
	 * @param refreshToken
	 * @return String
	 * @throws SignatureException
	 * @throws NullPointerException
	 * @throws BusinessException
	 * @throws SystemException
	 */
	public static String parseRefreshToken(String refreshToken) throws BusinessException {
		LOGGER.entry(refreshToken);
		refreshToken = decodeBase64(refreshToken);
		String userId;
		try {
			if (refreshToken != null) {
				// This line will throw an exception if it is not a signed JWS.
				Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(refreshToken).getBody();

				userId = (String) claims.get(TokenConstants.USER_ID);
			} else {
				throw new BusinessException(BusinessErrorCode.TOKEN_NOT_SET, BUNDLE.getString("TCRSPMAAUTH3007E")); // TODO
			}
		} catch (SignatureException e) {
			LOGGER.error(e.getMessage());
			throw new BusinessException(BusinessErrorCode.TOKEN_INVALID, e.getMessage());
		} catch (MalformedJwtException e) {
			LOGGER.error(e.getMessage());
			throw new BusinessException(BusinessErrorCode.TOKEN_INVALID, e.getMessage());
		}
		LOGGER.exit(userId);
		return userId;
	}

	/**
	 * Gets key value from the token given
	 * 
	 * @param token
	 * @return
	 */
	public static int parseAccessTokenToGetIntValue(String authToken, String key) {
		LOGGER.entry(authToken, key);
		authToken = decodeBase64(authToken);
		int value = 0;
		if (authToken != null) {
			Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken).getBody();
			if (claims.get(key) != null) {
				value = (Integer) claims.get(key);
			}
		}
		LOGGER.exit(value);
		return value;
	}

	/**
	 * Gets key value from the token given
	 * 
	 * @param token
	 * @return
	 */
	public static String parseAccessTokenToGetStringValue(String authToken, String key) {
		LOGGER.entry(authToken, key);
		authToken = decodeBase64(authToken);
		String value = null;
		if (authToken != null) {
			Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken).getBody();
			if (claims.get(key) != null) {
				value = (String) claims.get(key);
			}
		}
		LOGGER.exit(value);
		return value;
	}
}
