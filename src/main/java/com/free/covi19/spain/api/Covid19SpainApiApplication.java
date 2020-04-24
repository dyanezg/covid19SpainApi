package com.free.covi19.spain.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
public class Covid19SpainApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19SpainApiApplication.class, args);
	}

}
