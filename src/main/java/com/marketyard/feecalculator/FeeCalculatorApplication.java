package com.marketyard.feecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Market Fee Calculator Spring Boot application.
 * This class bootstraps and launches the embedded server, loading all
 * JPA entities, REST controllers, and service beans automatically via
 * Spring Boot's component scan.
 */
@SpringBootApplication
public class FeeCalculatorApplication {

	/**
	 * Application startup method.
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(FeeCalculatorApplication.class, args);
	}

}
