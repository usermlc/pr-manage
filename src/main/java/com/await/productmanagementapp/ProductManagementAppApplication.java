package com.await.productmanagementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Main application class for the Product Management App
@SpringBootApplication  // Enables auto-configuration, component scan, and Spring Boot features
public class ProductManagementAppApplication {

	// Main method to launch the Spring Boot application
	public static void main(String[] args) {
		SpringApplication.run(ProductManagementAppApplication.class, args);  // Runs the application
	}
}
