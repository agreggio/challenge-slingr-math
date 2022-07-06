package com.agreggio.challenge.slingr.math.security.controller;

import com.agreggio.challenge.slingr.math.security.component.LoginComponent;
import com.agreggio.challenge.slingr.math.security.domain.dto.LoginDTO;
import com.agreggio.challenge.slingr.math.security.domain.entity.Login;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
@Slf4j
public class UserController {

	@Autowired
	private LoginComponent loginComponent;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("login")
	public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO loginDTO) {

		Login login = modelMapper.map(loginDTO, Login.class);

		loginDTO = modelMapper.map(loginComponent.getLogin(login), LoginDTO.class);

		return ResponseEntity.ok(loginDTO);

	}


}


