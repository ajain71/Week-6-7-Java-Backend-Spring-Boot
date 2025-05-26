package com.example;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ErrorClass {
    private LocalDateTime timeStamp;
    private int status;
    private String message;

    public ErrorClass(LocalDateTime timeStamp, int status, String message) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
    }
}
