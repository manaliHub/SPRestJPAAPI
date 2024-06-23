package com.example.SPRestJPAAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public class RecordNotFoundException extends RuntimeException{

    //constructor1
    public RecordNotFoundException(String message) {
        super(message);
    }

    //constructor2
    public RecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
