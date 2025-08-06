package com.example.exception.custom;

public class InvalidInputDataException extends RuntimeException{
    public InvalidInputDataException(String message) {
        super(message);
    }
}
