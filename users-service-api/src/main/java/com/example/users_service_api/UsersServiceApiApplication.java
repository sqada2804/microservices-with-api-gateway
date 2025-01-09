package com.example.users_service_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.common_library.entity")
public class UsersServiceApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(UsersServiceApiApplication.class, args);
	}
}

