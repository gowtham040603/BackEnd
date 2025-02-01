package com.hexbee.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class UsermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermanagementApplication.class, args);
	}

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	    http
//	    .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/api/v1/ecommerce/user/login", "/api/products").permitAll() // Allow public access
//                .anyRequest().authenticated()
//            )// Allow all requests
//	        .csrf(csrf -> csrf.disable()) // Disable CSRF if needed
//	        .headers(headers -> headers.frameOptions().disable()); // Optional: for H2 console
//	        
//	    return http.build();
//	}

}
