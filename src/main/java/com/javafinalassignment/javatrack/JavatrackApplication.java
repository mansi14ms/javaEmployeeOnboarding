package com.javafinalassignment.javatrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavatrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavatrackApplication.class, args);
	}

}
