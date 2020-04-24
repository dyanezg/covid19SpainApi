package com.free.covi19.spain.api.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DbConfig {

  @Autowired
  private Environment env;

	 @Bean
	    public DataSource dataSource() {
	        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getProperty("driverClassName"));
	        dataSource.setUrl(env.getProperty("url"));
	        dataSource.setUsername(env.getProperty("user"));
	        dataSource.setPassword(env.getProperty("password"));
	        return dataSource;
	    }
	  

@Configuration
@Profile("local")
@PropertySource("classpath:application-local.properties")
class BDSqLiteConfig {
}  
}
