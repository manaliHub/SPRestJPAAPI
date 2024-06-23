package com.example.SPRestJPAAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //This method will handle all RecordNotFoundException
    @ExceptionHandler(value={RecordNotFoundException.class})
    public ResponseEntity<Object> recordNotFoundException(RecordNotFoundException recordNotFoundException){
        ErrorMessage errorMessage=new ErrorMessage(recordNotFoundException.getMessage(), recordNotFoundException.getCause(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }

    //This method will handle all Exceptions in this application
    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<Object> exceptions(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), exception.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //This method will handle all BadRequestException
    @ExceptionHandler(value={BadRequestException.class})
    public ResponseEntity<Object> badRequestException(BadRequestException badRequestException){
        ErrorMessage errorMessage=new ErrorMessage(badRequestException.getMessage(), badRequestException.getCause(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }

}
