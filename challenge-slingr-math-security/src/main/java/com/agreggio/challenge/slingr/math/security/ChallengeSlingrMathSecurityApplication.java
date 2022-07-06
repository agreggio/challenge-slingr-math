package com.agreggio.challenge.slingr.math.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan("com.agreggio.challenge.slingr.math")
@EntityScan("com.agreggio.challenge.slingr.math")
@EnableJpaAuditing
public class ChallengeSlingrMathSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeSlingrMathSecurityApplication.class, args);
	}

}
