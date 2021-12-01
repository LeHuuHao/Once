package com.trungtamjava.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class HellospringbootApplication {

    public static void main(String[] args) {
	SpringApplication.run(HellospringbootApplication.class, args);
    }

}
