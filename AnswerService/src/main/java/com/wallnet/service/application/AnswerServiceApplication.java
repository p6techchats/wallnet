package com.wallnet.service.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = { "com.wallnet.service.answer", "com.wallnet.service.appcommon","com.wallnet.service.mock" })
public class AnswerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnswerServiceApplication.class, args);
	}

}
