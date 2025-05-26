package com.example;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorClass {

    LocalDateTime timeStamp;
    int status;
    String message;

    public ErrorClass(LocalDateTime timeStamp, int status, String message) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
