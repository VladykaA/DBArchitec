package com.architec.service;

public interface CRUDService<T> {
    void save(T t);
    void update(T t);
}
