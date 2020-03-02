package com.wallnet.service.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.wallnet.service.qa"})
@EnableFeignClients(basePackages = {"com.wallnet.service.qa"})
public class QaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QaServiceApplication.class, args);
	}

}
