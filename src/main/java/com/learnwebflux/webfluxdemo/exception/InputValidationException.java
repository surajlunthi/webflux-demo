package com.learnwebflux.webfluxdemo.exception;

public class InputValidationException extends RuntimeException{
    private static final String MSG = "Allowed Range is from 10 to 20";
    public static final int errorCode = 10;
    private final int input ;

    public int getInput() {
        return input;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public InputValidationException(int input) {
        super(MSG);
        this.input = input;
    }
}
