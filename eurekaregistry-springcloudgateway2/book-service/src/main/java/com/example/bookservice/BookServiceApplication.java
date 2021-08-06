package com.example.bookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BookServiceApplication {

	/**
	 * http://localhost:8100/book-service/1/BRL
	 * */
	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

}
