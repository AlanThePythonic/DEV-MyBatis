package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootConfiguration
@SpringBootApplication
@EnableCaching
public class MySpringBootApplication implements HealthIndicator {
	private static Logger logger = LoggerFactory.getLogger(MySpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApplication.class, args);
		logger.info("My Spring Boot Application Started");
	}

	@Override
	public Health health() {
		return Health.up().withDetail("hello", "world").build();
	}
}
