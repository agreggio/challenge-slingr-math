package com.agreggio.challenge.slingr.math.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T, S> extends JpaRepository<T, S>  {

}
