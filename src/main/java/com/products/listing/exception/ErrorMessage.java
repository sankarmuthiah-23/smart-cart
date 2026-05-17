package com.products.listing.exception;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorMessage {

    private String message;
    private Date timestamp;
    private int statusCode;

    public ErrorMessage(String message, int statusCode) {
        this.message = message;
        this.timestamp = new Date();
        this.statusCode = statusCode;
    }


}
