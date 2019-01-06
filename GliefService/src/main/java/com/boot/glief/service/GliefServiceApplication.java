package com.boot.glief.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GliefServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GliefServiceApplication.class, args);
	}

}

