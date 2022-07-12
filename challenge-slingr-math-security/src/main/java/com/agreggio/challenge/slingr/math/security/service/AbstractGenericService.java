package com.agreggio.challenge.slingr.math.security.service;


import com.agreggio.challenge.slingr.math.security.repository.GenericRepository;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractGenericService<T, S extends Serializable> implements GenericService<T, S> {

    protected final GenericRepository<T, S> dao;

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public T save(T entity) {
        return dao.save(entity);
    }

    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteById(S id) {
        dao.deleteById(id);
    }

    @Override
    public long count() {
        return dao.count();
    }

    @Override
    public Optional<T> findById(S id) {
        return dao.findById(id);
    }

    @Override
    public List<T> saveAll(Iterable<T> iterable) {
        return dao.saveAll(iterable);
    }

}
