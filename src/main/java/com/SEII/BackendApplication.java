package com.SEII;

import com.SEII.repositories.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EnableJpaRepositories(basePackageClasses = PersonRepository.class)
public class BackendApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(BackendApplication.class);
	 
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		
		LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
	}

}
