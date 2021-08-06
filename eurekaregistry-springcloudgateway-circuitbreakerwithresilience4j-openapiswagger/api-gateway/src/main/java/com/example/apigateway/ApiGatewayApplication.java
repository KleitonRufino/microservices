package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {

	/**
	 * http://localhost:8765/cambio-service/5/USD/BRL
	 * http://localhost:8765/book-service/1/BRL
	 * */
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
