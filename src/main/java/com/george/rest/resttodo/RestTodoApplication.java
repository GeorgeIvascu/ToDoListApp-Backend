package com.george.rest.resttodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.george"})
public class RestTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTodoApplication.class, args);
	}

}
