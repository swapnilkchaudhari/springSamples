package com.example.eurekaClientStatement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientStatementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientStatementApplication.class, args);
	}

}

