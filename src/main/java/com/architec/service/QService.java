package com.architec.service;

public interface QService<P, T> extends CRUDService<T> {

    T getQByKey(String key);

    void update(P p ,T t);

    void delete(P p, T t);


}
