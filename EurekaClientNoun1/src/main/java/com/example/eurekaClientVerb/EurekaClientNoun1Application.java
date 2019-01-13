
package com.example.eurekaClientVerb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientNoun1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientNoun1Application.class, args);
	}

}

