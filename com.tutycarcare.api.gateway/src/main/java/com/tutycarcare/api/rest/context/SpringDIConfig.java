package com.tutycarcare.api.rest.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.tutycarcare.api.gateway.GatewayService;
import com.tutycarcare.api.gateway.ServiceDiscovery;
import com.tutycarcare.commons.security.CustomAuthenticatedUser;

@Configuration
@ComponentScan(basePackageClasses = {GatewayService.class, CustomAuthenticatedUser.class, ServiceDiscovery.class})
@ImportResource("classpath:/security-context.xml")
public class SpringDIConfig {

}
