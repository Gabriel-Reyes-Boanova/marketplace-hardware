package com.gabriel.marketplace.service;

import com.gabriel.marketplace.dto.ExternalProductDTO.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DummyJsonProductsService
        implements ApiRequestService<DummyJsonProductResponse, Integer> {

    private final RestClient restClient;

    public DummyJsonProductsService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://dummyjson.com")
                .build();
    }

    @Override
    public List<DummyJsonProductResponse> findAll() {

        DummyJsonProductsResponse response = restClient.get()
                .uri("/products")
                .retrieve()
                .body(DummyJsonProductsResponse.class);

        verifyDummyProductResponse(response);

        if (response.products() == null) {
            throw new IllegalStateException(
                    "A API externa não retornou a lista de produtos."
            );
        }

        return response.products();
    }

    @Override
    public DummyJsonProductResponse findById(Integer id) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException(
                    "O ID deve ser maior que zero."
            );
        }

        DummyJsonProductResponse response = restClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .body(DummyJsonProductResponse.class);

        verifyDummyProductResponse(response);

        return response;
    }

    private void verifyDummyProductResponse(Object response) {
        if (response == null) {
            throw new IllegalStateException(
                    "A API externa retornou uma resposta vazia."
            );
        }
    }
}