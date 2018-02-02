package com.tutycarcare.api.rest.util;

import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tutycarcare.api.rest.constants.EnvVariableConstants;

/**
 * Contains utilities needed for environment variable
 * 
 * @author Coda Global Team
 *
 */
public class EnvVariableUtil {
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(EnvVariableConstants.ENV_VARIABLE_BUNDLE);
	private final static Logger LOGGER = LogManager.getLogger();

	/**
	 * Get environment variable from server for the given key
	 * 
	 * @param key
	 * @param fromServer
	 * @return
	 */
	public static String getValue(String key, boolean fromServer) {
		LOGGER.entry(key, fromServer);
		String value = null;
		if (fromServer) {
			value = System.getenv(key);
		}
		if (null == value || !fromServer) {
			// read from properties file
			value = BUNDLE.getString(key);
		}
		LOGGER.exit(value);
		return value;
	}

	/**
	 * Get boolean value from string
	 * 
	 * @param key
	 * @param fromServer
	 * @return
	 */
	public static boolean getBooleanValue(String key, boolean fromServer) {
		LOGGER.entry(key, fromServer);
		boolean value = false;
		String stringValue = getValue(key, fromServer);
		value = Boolean.parseBoolean(stringValue);
		LOGGER.exit(value);
		return value;
	}
}
