package com.tutycarcare.api.gateway;

import org.springframework.stereotype.Component;

import com.tutycarcare.api.rest.constants.EnvVariableConstants;
import com.tutycarcare.api.rest.util.EnvVariableUtil;

@Component
public class ServiceDiscovery {

	// Getting Url for Inter Service Communication
	public static String customerURL = null;
	public static String vehicleURL = null;
	/**
	 * Constructor to get Url for ISC from environmental variable
	 */
	public ServiceDiscovery() {
		customerURL = EnvVariableUtil.getValue(EnvVariableConstants.CUSTOMER_SERVICE_URL, true);
		vehicleURL = EnvVariableUtil.getValue(EnvVariableConstants.VEHICLE_SERVICE_URL, true);
		
	}

	public String getServiceURL(String path) {
		String serviceURL = "";

		switch (path) {
			case "customer":
				serviceURL = customerURL;
				break;
			case "vehicle":
				serviceURL = vehicleURL;
				break;
		}
		return serviceURL;
	}
}
