package com.gabriel.marketplace.controller;

import com.gabriel.marketplace.dto.ExternalProductDTO.DummyJsonProductResponse;
import com.gabriel.marketplace.service.ApiRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/external/products")
@RequiredArgsConstructor
public class ExternalApiController {

    private final ApiRequestService<DummyJsonProductResponse, Integer> service;

    @GetMapping
    public ResponseEntity<List<DummyJsonProductResponse>> findAllProducts() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DummyJsonProductResponse> findProductById(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(service.findById(id));
    }
}