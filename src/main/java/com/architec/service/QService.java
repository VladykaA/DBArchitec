package com.architec.service;

public interface QService<P, T> extends CRUDService<T> {

    T getQByKey(String key);
    }
