package com.category.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GoodsResponse {
    private String categoryName;
    private Long brandNo;
    private String brandName;
    private Long price;

    public GoodsResponse(Long brandNo, String brandName, Long price) {
        this.brandNo = brandNo;
        this.brandName = brandName;
        this.price = price;
    }

    public GoodsResponse(String categoryName, Long brandNo, String brandName, Long price) {
        this.categoryName = categoryName;
        this.brandNo = brandNo;
        this.brandName = brandName;
        this.price = price;
    }
}