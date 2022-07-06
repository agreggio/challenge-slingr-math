package com.agreggio.challenge.slingr.math.security.repository;


import com.agreggio.challenge.slingr.math.security.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericRepository<User, Long> {

    Optional<User> findUserByUserNameAndPassword(String username, String password);
}
