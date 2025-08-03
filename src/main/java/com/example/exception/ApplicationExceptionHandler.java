package com.example.exception;

import com.example.exception.custom.InvalidInputDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorCode> handleException(Exception e) {
        ErrorCode errorCode = new ErrorCode();
        errorCode.setMessage("Something went wrong: " + e.getMessage());
        errorCode.setCode(-1);
        return new ResponseEntity<>(errorCode, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(InvalidInputDataException.class)
    public ResponseEntity<ErrorCode> handleInvalidInputDataException(InvalidInputDataException e) {
        ErrorCode errorCode = new ErrorCode();
        errorCode.setMessage(e.getMessage());
        errorCode.setCode(100);
        return new ResponseEntity<>(errorCode, HttpStatus.BAD_REQUEST);
    }
}
