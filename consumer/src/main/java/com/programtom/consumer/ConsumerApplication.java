package com.programtom.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		//This would be needed for RabbitMQ variant - for Inter - Micro Service Communication
//		System.setProperty("spring.amqp.deserialization.trust.all", "true");

		SpringApplication.run(ConsumerApplication.class, args);
	}

}
