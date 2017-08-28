package com.kershaw.poc.websecurity;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	public static Authentication getAuthentication() { 
		
		System.out.println("hwlllllllllllllooo223w" + SecurityContextHolder.getContext().getAuthentication().getName());
		         return SecurityContextHolder.getContext().getAuthentication(); 
		    } 
		
		 


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("config");
		http.csrf().disable().authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("config_1");
		auth.ldapAuthentication().userDnPatterns("uid={0},ou=people")
				.contextSource(contextSource()).passwordCompare().passwordAttribute("userPassword");
	}

	@Bean
	public DefaultSpringSecurityContextSource contextSource() {
		return  new DefaultSpringSecurityContextSource(Arrays.asList("ldap://localhost:8389/"), "dc=springframework,dc=org");
	}
}
