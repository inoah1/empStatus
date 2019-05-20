package com.noah.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmpStatusApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpStatusApplication.class, args);
	}

}
