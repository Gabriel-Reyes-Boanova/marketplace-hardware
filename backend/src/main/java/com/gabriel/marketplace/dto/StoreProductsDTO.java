package com.gabriel.marketplace.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class StoreProductsDTO {

    private StoreProductsDTO(){}

    record StoreProductRequest(
        String title,
        String description,
        String category,
        BigDecimal price,
        Integer quantity
    ){}

    record StoreProductResponse(
            UUID id,
        String title,
        String description,
        String category,
        BigDecimal price,
        Integer quantity,
        String imageUrl,
        String sellerName,
        String sellerEmail,
        Boolean active
    ){}
}
