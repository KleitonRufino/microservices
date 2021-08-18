package com.example.pedido;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableRabbit
@EnableEurekaClient
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@SpringBootApplication
public class PedidoApplication {

	/**
	 * AUTHORIZATION 
	 * POST http://localhost:8093/authentication/login { "username":"admin", "password": "pwd" }
	 * 
	 * http://localhost:8091/pedido/order/save
	 * POST { "idMenu": 18, "idClient": 16, "idRestaurant": 17, "price": 12345 }
	 * HEADER AUTENTICACAO TOKEN
	 * */
	public static void main(String[] args) {
		SpringApplication.run(PedidoApplication.class, args);
	}

}
