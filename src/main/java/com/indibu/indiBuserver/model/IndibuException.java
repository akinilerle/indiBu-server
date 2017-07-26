package com.indibu.indiBuserver.model;

import org.springframework.http.HttpStatus;

public class IndibuException extends RuntimeException {

    private HttpStatus httpStatus;

    public IndibuException() {
    }

    public IndibuException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
