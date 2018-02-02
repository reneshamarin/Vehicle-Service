package com.tutycarcare.service.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.tutycarcare.service.config.SpringDIConfig;

@Configuration
@Import(SpringDIConfig.class)
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, Neo4jDataAutoConfiguration.class  })
@EnableFeignClients
public class VehicleMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleMicroServiceApplication.class, args);
	}
}