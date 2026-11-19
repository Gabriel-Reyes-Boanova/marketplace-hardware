package com.gabriel.marketplace.exception;

public class CategoryNotFindException extends RuntimeException {
    public CategoryNotFindException(String message) {
        super(message);
    }
}
