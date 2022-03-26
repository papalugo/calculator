package com.comin.claudinei.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorRestApplication {

    public static final String PREFIX = "REST: ";

    public static void main(String[] args) {
		SpringApplication.run(CalculatorRestApplication.class, args);
	}

}
