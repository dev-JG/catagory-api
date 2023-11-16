package com.category.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductAddRequest {
    private Long brandNo;
    private Long categoryNo;
    private String name;
    private Long price;
}