package com.Andres.Yapily.entity;

import org.springframework.http.HttpStatus;

public class SimpleErrorException extends RuntimeException{

    private final HttpStatus status;
    private final String message;

    public SimpleErrorException(HttpStatus status, String message) {
        super(status.getReasonPhrase());
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}