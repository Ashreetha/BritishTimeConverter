package com.example.exception;

import java.time.LocalDateTime;

public class ErrorCode {
    LocalDateTime dateTime;
    String message;

    public ErrorCode(LocalDateTime now, String msg) {
        this.message = msg;
        this.dateTime = now;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return dateTime;
    }

    public void setCode(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
