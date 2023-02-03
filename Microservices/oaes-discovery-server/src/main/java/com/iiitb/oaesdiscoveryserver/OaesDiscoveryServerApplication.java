package com.iiitb.oaesdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OaesDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OaesDiscoveryServerApplication.class, args);
	}

}
