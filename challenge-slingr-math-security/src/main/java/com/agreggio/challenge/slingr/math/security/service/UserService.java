package com.agreggio.challenge.slingr.math.security.service;

import com.agreggio.challenge.slingr.math.security.domain.entity.User;

public interface UserService {


    User findUser(String username, String password);
}
