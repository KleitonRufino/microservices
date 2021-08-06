package com.example.cambioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CambioServiceApplication {

	 /**
	  * http://localhost:8000/cambio-service/5/USD/BRL
	  * */
	public static void main(String[] args) {
		SpringApplication.run(CambioServiceApplication.class, args);
	}

}
