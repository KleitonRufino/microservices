package com.example.autenticacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AutenticacaoApplication {

	/*
	 * AUTHORIZATION
	 * POST http://localhost:8093/authentication/login { "username":"admin", "password": "pwd" }
	 */ 
	public static void main(String[] args) {
		SpringApplication.run(AutenticacaoApplication.class, args);
	}

}
