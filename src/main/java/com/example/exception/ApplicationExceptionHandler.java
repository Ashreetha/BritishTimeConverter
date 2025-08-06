package com.example.exception;

import com.example.exception.custom.InvalidInputDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorCode> handleException(Exception e) {
        ErrorCode errorCode = new ErrorCode(LocalDateTime.now(),"Something went wrong: " + e.getMessage());
        return new ResponseEntity<>(errorCode, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(InvalidInputDataException.class)
    public ResponseEntity<ErrorCode> handleInvalidInputDataException(InvalidInputDataException e) {
        ErrorCode errorCode = new ErrorCode(LocalDateTime.now(),"Supplied time input is invaild. Please use 24 hour time pattern of HH:MM as input: " + e.getMessage());
        return new ResponseEntity<>(errorCode, HttpStatus.BAD_REQUEST);
    }
}
