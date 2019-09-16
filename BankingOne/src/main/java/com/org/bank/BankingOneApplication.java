package com.org.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableEurekaClient
@EntityScan("com.org.domain")
@EnableMongoRepositories
public class BankingOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingOneApplication.class, args);
	}

}
