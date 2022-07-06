package com.agreggio.challenge.slingr.math.security.configuration;


import com.agreggio.challenge.slingr.math.security.domain.entity.User;
import com.agreggio.challenge.slingr.math.security.domain.enums.UserRole;
import com.agreggio.challenge.slingr.math.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class InitConfig {


	@Autowired
	private UserRepository userRepository;


	@PostConstruct
	public void populateTable(){

		populateUser();

	}

	private void populateUser() {

		User user = new User(
				"test",
				"admin",
				"test",
				"admin",
		UserRole.ROLE_ADMIN);

		userRepository.save(user);

	}




}
