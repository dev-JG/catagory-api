package com.category.config.exception;

import com.category.model.enums.CustomExceptionStatus;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

    private final HttpStatus httpStatus;

    public CustomException(CustomExceptionStatus customExceptionStatus) {
        super(customExceptionStatus.getMessage());
        this.httpStatus = customExceptionStatus.getHttpStatus();
    }
}