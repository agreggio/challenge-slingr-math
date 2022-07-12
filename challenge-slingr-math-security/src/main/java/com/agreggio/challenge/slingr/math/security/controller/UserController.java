package com.agreggio.challenge.slingr.math.security.controller;

import com.agreggio.challenge.slingr.math.security.component.LoginComponent;
import com.agreggio.challenge.slingr.math.security.model.dto.LoginDTO;
import com.agreggio.challenge.slingr.math.security.model.dto.UserDTO;
import com.agreggio.challenge.slingr.math.security.model.entity.Login;
import com.agreggio.challenge.slingr.math.security.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserController {

	@Autowired
	private LoginComponent loginComponent;

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@ApiOperation(value = "Retrieve access token by user", produces = APPLICATION_JSON_VALUE)
	@PostMapping("/login")
	public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO loginDTO) {

		log.info("{} user is logging", loginDTO.getUsername());

		Login login = modelMapper.map(loginDTO, Login.class);

		loginDTO = modelMapper.map(loginComponent.getLogin(login), LoginDTO.class);

		return ResponseEntity.ok(loginDTO);

	}

	@ApiOperation(value = "Retrieve user by id", produces = APPLICATION_JSON_VALUE)
	@GetMapping("/{userName}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable String userName) {

		log.info("Get user by userName {}", userName);


		return ResponseEntity.ok(modelMapper.map(userService.findUser(userName), UserDTO.class));

	}


}


