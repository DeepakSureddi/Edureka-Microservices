package com.edureka.activemq_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;

@SpringBootApplication
public class Activemq1Application {

	@JmsListener(destination = "inventory-queue")
	public void listen(String message) {
		System.out.println("activemq_1: " + message);
	}

	public static void main(String[] args) {
		SpringApplication.run(Activemq1Application.class, args);
	}

}
