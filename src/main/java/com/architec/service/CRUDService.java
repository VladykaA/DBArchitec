package com.architec.service;

import java.util.List;

public interface CRUDService<T> {

    void save(T t);

    T getById(int id);

    List<T> getAll();

}
