package com.edureka.commandms;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@SpringBootApplication
@RestController
@EnableJms
public class CommandmsApplication {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Queue orderQueue;
	@Autowired
	private Queue inventoryQueue;

	@Bean
	public Queue orderQueue() {
		return new ActiveMQQueue("order-queue");
	}

	@Bean
	public Queue inventoryQueue() {
		return new ActiveMQQueue("inventory-queue");
	}

	@GetMapping("/messages/{message}")
	public void publish(@PathVariable String message) {
		System.out.println("CommandMS: " + message);
		jmsTemplate.convertAndSend(orderQueue, "order-" + message);
		jmsTemplate.convertAndSend(inventoryQueue, "inv-" + message);
	}

	public static void main(String[] args) {
		SpringApplication.run(CommandmsApplication.class, args);
	}

}
