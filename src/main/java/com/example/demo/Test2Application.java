package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
importorg.springframework.boot.builder.SpringApplicationBuilder;
importorg.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Test2Application extends SpringBootServletInitializer{

@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder 
application) {
        return application.sources(Test2Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Test2Application.class, args);
	}

}
