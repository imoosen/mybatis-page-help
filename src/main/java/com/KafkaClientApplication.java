package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class KafkaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaClientApplication.class, args);
	}
}
