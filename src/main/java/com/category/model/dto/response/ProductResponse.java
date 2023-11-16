package com.category.model.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponse {
    @JsonIgnore
    private Long brandNo;
    private String brandName;
    private Long price;

    public ProductResponse(Long brandNo, String brandName, Long price) {
        this.brandNo = brandNo;
        this.brandName = brandName;
        this.price = price;
    }
}