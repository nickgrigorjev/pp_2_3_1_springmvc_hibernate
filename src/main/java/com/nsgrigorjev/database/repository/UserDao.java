package com.nsgrigorjev.database.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface UserDao<T, ID extends Serializable> {
    T findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
    void delete(T entity);
    <S extends T> void persist(S entity);
    <S extends T> void update(S entity);
}
