package com.example.homebootcamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeBootcampApplication {

	private static final Logger logger = LogManager.getLogger("HomeBootcampApplication");

	public static void main(String[] args) {
		logger.info("Started Bootcamp Application");
		SpringApplication.run(HomeBootcampApplication.class, args);
	}

}
