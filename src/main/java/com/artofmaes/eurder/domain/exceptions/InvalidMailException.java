package com.artofmaes.eurder.domain.exceptions;

public class InvalidMailException extends RuntimeException {

    public InvalidMailException(String message){
        super(message);
    }

    public InvalidMailException(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidMailException(Throwable cause){
        super(cause);
    }
}
