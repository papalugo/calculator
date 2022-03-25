package com.comin.claudinei.calc;

import com.comin.claudinei.calc.service.impl.RabbitMqReceiverService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class CalculatorCalcApplication {

    public static final String PREFIX = "CALC ";

    public static void main(String[] args) {
		SpringApplication.run(CalculatorCalcApplication.class, args);
	}

}
