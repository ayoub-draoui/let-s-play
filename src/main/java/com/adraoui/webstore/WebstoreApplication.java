package com.adraoui.webstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class WebstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebstoreApplication.class, args);
	}

}
