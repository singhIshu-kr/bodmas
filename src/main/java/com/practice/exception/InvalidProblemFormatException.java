package com.practice.exception;

public class InvalidProblemFormatException extends RuntimeException {
    public InvalidProblemFormatException(String message) {
        super(message);
    }
}
