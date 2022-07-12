package com.agreggio.challenge.slingr.math.security.service.impl;

import com.agreggio.challenge.slingr.math.security.model.entity.User;
import com.agreggio.challenge.slingr.math.security.repository.UserRepository;
import com.agreggio.challenge.slingr.math.security.service.AbstractGenericService;
import com.agreggio.challenge.slingr.math.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class UserServiceImpl extends AbstractGenericService<User, Long> implements UserService {


	private final UserRepository userRepository;


	public UserServiceImpl(UserRepository userRepository) {
		super(userRepository);
		this.userRepository = userRepository;

	}


	@Override
	public User findUser(String username, String password) {
		return userRepository.findUserByUserNameAndPassword(username, password)
				.orElseThrow(() -> new UsernameNotFoundException("User not Found with username: " + username));
	}

	@Override
	public User findUser(String username) {
		return userRepository.findUserByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not Found with username: " + username));
	}
}
