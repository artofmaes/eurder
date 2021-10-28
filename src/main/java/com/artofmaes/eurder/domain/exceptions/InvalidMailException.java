package com.artofmaes.eurder.domain.exceptions;

public class InvalidMailException extends RuntimeException {

    public InvalidMailException(String message){
        super(message);
    }
}
