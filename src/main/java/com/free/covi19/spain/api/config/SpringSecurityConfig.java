package com.free.covi19.spain.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}ascv_lodf").roles("USER");                            
    }
	
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http
	                .httpBasic()
	                .and()
	                .authorizeRequests()
	                .antMatchers(HttpMethod.GET, "/api/modeloDatos/**").hasRole("USER")	                
	                .and()
	                .csrf().disable();
	                
	    }

}
