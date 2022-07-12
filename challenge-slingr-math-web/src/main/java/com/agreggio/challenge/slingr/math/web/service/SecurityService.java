package com.agreggio.challenge.slingr.math.web.service;

import com.agreggio.challenge.slingr.math.web.model.dto.JwtDTO;
import com.agreggio.challenge.slingr.math.web.model.dto.UserDTO;

public interface SecurityService {

    UserDTO getUserByUserName(JwtDTO jwtDTO);
}
