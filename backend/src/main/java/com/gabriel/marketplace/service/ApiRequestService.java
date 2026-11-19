package com.gabriel.marketplace.service;

import java.util.List;

public interface ApiRequestService<T, ID> {

    List<T> findAll();

    T findById(ID id);
}