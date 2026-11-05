package com.gabriel.marketplace.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum Role {
    ADMIN("admin"),
    SELLER("seller"),
    CUSTUMER("custumer");

    private final String description;
}
