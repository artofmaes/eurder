package com.artofmaes.eurder.domain.exceptions;

public class UnauthorizedUserException extends RuntimeException {
    public UnauthorizedUserException(String message){
        super(message);
    }
}
