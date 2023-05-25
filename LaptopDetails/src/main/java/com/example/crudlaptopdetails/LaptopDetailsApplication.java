package com.example.crudlaptopdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Laptopdetails api"))
public class LaptopDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaptopDetailsApplication.class, args);
	}
	

}
