package com.edureka.activemq_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;

@SpringBootApplication
public class Activemq2Application {

	@JmsListener(destination = "order-queue")
	public void listen(String message) {
		System.out.println("activemq_2: " + message);
	}

	public static void main(String[] args) {
		SpringApplication.run(Activemq2Application.class, args);
	}

}
