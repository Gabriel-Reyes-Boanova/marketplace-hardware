package com.gabriel.marketplace.service;

import com.gabriel.marketplace.repository.StoreProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreProductService {

    private final StoreProductRepository repository;

}
