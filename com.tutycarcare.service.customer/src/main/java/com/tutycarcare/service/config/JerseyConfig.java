package com.tutycarcare.service.config;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.tutycarcare.service.api.CustomerServiceResource;

@Configuration
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(MultiPartFeature.class);
		register(CustomerServiceResource.class);
	}
}