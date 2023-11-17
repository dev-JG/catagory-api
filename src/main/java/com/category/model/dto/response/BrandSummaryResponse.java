package com.category.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BrandSummaryResponse {
    private Long brandNo;
    private String brandName;
    private Long totalPrice;

    public BrandSummaryResponse(Long brandNo, String brandName, Long totalPrice) {
        this.brandNo = brandNo;
        this.brandName = brandName;
        this.totalPrice = totalPrice;
    }
}