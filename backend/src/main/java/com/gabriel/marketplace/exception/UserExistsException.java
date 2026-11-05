package com.gabriel.marketplace.exception;

public class UserExistsException extends RuntimeException{

    public UserExistsException(String message){
        super(message);
    }
}
