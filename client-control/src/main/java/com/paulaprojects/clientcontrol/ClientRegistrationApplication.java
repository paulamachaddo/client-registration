package com.paulaprojects.clientcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ClientRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientRegistrationApplication.class, args);
	}

}
