package com.category.config.handler;

import com.category.config.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        return new ResponseEntity<>(
                ex.getMessage(),
                ex.getHttpStatus()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllException(Exception ex) {
        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.SERVICE_UNAVAILABLE
        );
    }
}