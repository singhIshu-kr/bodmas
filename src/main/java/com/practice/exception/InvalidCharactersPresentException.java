package com.practice.exception;

public class InvalidCharactersPresentException extends RuntimeException {
    public InvalidCharactersPresentException(String message) {
        super(message);
    }
}
