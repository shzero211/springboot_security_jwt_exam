package com.ll.exam.spring_security_jwt_exam;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableJpaAuditing
@SpringBootApplication
public class SpringSecurityJwtExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtExamApplication.class, args);
	}
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	public ObjectMapper objectMapper(){
		return new ObjectMapper();
	}
}
