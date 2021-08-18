package com.example.cadastro;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@EnableRabbit
@EnableCaching
@EnableEurekaClient
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@SpringBootApplication
public class CadastroApplication {

	/**
	 * AUTHORIZATION 
	 * POST http://localhost:8093/authentication/login { "username":"admin", "password": "pwd" }
	 * 
	 * http://localhost:8080/cadastro/client/save
	 * POST { "name":"jose2", "email": "jose2@email.com", "user":"jose2", "password": "12345" }
	 * HEADER AUTENTICACAO TOKEN
	 * 
	 * http://localhost:8090/cadastro/restaurant/save
	 * POST { "name":"restaurante", "email": "restaurante@email.com", "user":"restaurante", "password": "12345" }
	 * HEADER AUTENTICACAO TOKEN
	 * 
	 * http://localhost:8090/cadastro/menu/save
	 * POST { "name":"restaurante", "price": 10, "idRestaurant": 9 }
	 * HEADER AUTENTICACAO TOKEN
	 * 
	 * */
	public static void main(String[] args) {
		SpringApplication.run(CadastroApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/cadastro").allowedOrigins("*");
			}
		};
	}
}
