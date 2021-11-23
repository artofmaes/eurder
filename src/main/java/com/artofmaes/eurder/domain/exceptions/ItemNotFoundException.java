package com.artofmaes.eurder.domain.exceptions;

public class ItemNotFoundException extends RuntimeException{
    private static final String ITEM_NOT_FOUND_EXCEPTION = "No such item found.";

    public ItemNotFoundException() {
        super(ITEM_NOT_FOUND_EXCEPTION);
    }
}

