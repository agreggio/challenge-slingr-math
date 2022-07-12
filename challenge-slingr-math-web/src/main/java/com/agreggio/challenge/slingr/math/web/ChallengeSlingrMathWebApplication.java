package com.agreggio.challenge.slingr.math.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.agreggio.challenge.slingr.math")
@EntityScan("com.agreggio.challenge.slingr.math")
public class ChallengeSlingrMathWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeSlingrMathWebApplication.class, args);
	}


}
