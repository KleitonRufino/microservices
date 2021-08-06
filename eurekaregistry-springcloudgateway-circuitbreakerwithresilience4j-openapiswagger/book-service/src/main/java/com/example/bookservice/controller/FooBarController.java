package com.example.bookservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Foo bar")
@RestController
@RequestMapping("book-service")
public class FooBarController {

	private Logger logger = LoggerFactory.getLogger(FooBarController.class);

	@GetMapping("/foo-bar")
	@Operation(summary = "Foo bar")
	// @Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
	// @CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")//se
	// atingir % de erro pula direto pro fallbackMethid
	// @RateLimiter(name = "default")//limitar qtd de request por segundo
	@Bulkhead(name = "default") // definir qtd max de chamadas concorrentes
	public String fooBar() {
		logger.info("Request to foo-bar is received!");

//		  var response = new RestTemplate()
//		  .getForEntity("http://localhost:8080/foo-bar", String.class);

		return "Foo-Bar!!!";
		// return response.getBody();
	}

	public String fallbackMethod(Exception ex) {
		return "fallbackMethod foo-bar!!!";
	}
}