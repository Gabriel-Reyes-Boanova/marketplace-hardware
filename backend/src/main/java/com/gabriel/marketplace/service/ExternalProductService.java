package com.gabriel.marketplace.service;

import com.gabriel.marketplace.dto.ExternalProductDTO.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ExternalProductService {

    private final RestClient restClient;

    public ExternalProductService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://dummyjson.com")
                .build();
    }

    public List<DummyJsonProductResponse> findAllProducts() {

        DummyJsonProductsResponse response = restClient.get()
                .uri("/products")
                .retrieve()
                .body(DummyJsonProductsResponse.class);

        if (response == null || response.products() == null) {
            throw new IllegalStateException(
                    "Falha ao obter produtos do servidor externo."
            );
        }

        return response.products();
    }
}