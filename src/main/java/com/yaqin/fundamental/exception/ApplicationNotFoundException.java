package com.yaqin.fundamental.exception;

public class ApplicationNotFoundException extends RuntimeException {
    public ApplicationNotFoundException(String exception) {
        super(exception);
    }
}

