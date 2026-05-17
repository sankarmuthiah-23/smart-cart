package com.products.listing.exception;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
