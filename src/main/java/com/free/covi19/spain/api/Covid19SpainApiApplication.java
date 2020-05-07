package com.free.covi19.spain.api;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

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

	
	  @PostConstruct
	    void started() {
	        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
	    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(Covid19SpainApiApplication.class, args);
	}

}
