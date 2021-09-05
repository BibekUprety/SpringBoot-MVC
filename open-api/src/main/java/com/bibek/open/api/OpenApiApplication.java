package com.bibek.open.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class OpenApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenApiApplication.class, args);
	}

}
