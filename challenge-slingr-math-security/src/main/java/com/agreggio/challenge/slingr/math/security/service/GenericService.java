package com.agreggio.challenge.slingr.math.security.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericService<T, S extends Serializable> {

    List<T> findAll();

    T save(T entity);

    void delete(T entity);

    void deleteById(S id);

    long count();

    Optional<T> findById(S id);

    List<T> saveAll(Iterable<T> iterable);

}
