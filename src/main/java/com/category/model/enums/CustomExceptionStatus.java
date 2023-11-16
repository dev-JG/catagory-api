package com.category.model.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CustomExceptionStatus {

    INVALID_CATEGORY_INFO("유요하지않은 카테고리입니다.", HttpStatus.NOT_FOUND),
    INVALID_BRAND_INFO("유요하지않은 브랜드입니다.", HttpStatus.NOT_FOUND),
    INVALID_PRODUCT_INFO("유요하지않은 상품입니다.", HttpStatus.NOT_FOUND);

    private String message;
    private final HttpStatus httpStatus;

    CustomExceptionStatus(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
