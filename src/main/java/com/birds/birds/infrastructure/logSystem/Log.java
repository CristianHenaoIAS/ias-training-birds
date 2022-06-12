package com.birds.birds.infrastructure.logSystem;

import java.time.LocalDate;

public class Log {
    private final String message;
    private final String statusCode;

    public Log(String message, String statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public void logger(){
        System.out.println("Status code: " + statusCode + " Message: " + message + " Date: " + LocalDate.now());
    }
}
