package com.agreggio.challenge.slingr.math.security.service;

import com.agreggio.challenge.slingr.math.security.model.entity.User;

public interface UserService {


    /**
     * Find user by.
     *
     * @param username {@link String}
     * @param password {@link String}
     *
     * @return {@link User}
     */
    User findUser(String username, String password);
}
