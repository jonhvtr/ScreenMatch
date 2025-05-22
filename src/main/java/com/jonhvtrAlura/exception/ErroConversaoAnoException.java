package com.jonhvtrAlura.exception;

public class ErroConversaoAnoException extends RuntimeException {
    private final String message;

    public ErroConversaoAnoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
