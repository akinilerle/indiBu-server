package com.indibu.indiBuserver.model;

public class ErrorResponse {

    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public ErrorResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
