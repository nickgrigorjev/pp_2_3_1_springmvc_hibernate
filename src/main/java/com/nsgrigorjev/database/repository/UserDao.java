package com.nsgrigorjev.database.repository;

import java.io.Serializable;
import java.util.List;

public interface UserDao<T, I extends Serializable> {
    T findById(I id);
    List<T> findAll();
    void deleteById(I id);
    void delete(T entity);
    <S extends T> void persist(S entity);
    <S extends T> void update(S entity);
    void executeNativeQuery(String sql);
}
