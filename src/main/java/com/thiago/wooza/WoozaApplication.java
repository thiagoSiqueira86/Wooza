package com.thiago.wooza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class WoozaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WoozaApplication.class, args);
	}

}
