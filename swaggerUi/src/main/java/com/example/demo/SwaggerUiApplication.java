package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "swagerui", version = "1.0", description = "register user for swagger", contact = @Contact(name = "aswini", email = "akj.sites@gmail.com")))
@SpringBootApplication(scanBasePackages = "com")
@EnableJpaRepositories(basePackages = "com.example.myrepo")
@EntityScan("com.example.entity")
@EnableCaching
public class SwaggerUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerUiApplication.class, args);
	}

}
