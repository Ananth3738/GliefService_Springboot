package com.boot.glief.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@EnableJpaRepositories(basePackages = "com.boot.glief.service.repository")
@SpringBootApplication
public class GliefServiceApplication {

	/*
	Spring boot start application
	 */
	public static void main(String[] args) {
		SpringApplication.run(GliefServiceApplication.class, args);
	}

}

