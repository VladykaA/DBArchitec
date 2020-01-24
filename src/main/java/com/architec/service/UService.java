package com.architec.service;

public interface UService<T> extends CRUDService<T> {

    void update(T t);

    void delete(T t);

}
