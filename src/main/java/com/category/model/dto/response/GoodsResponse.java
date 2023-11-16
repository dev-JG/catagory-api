package com.category.model.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GoodsResponse {
    @JsonIgnore private Long goodsNo;
    @JsonIgnore private Long categoryNo;
    private String categoryName;
    private Long brandNo;
    private String brandName;
    private Long price;

    public GoodsResponse(Long brandNo, String brandName, Long price) {
        this.brandNo = brandNo;
        this.brandName = brandName;
        this.price = price;
    }

    public GoodsResponse(Long goodsNo, Long categoryNo, String categoryName, Long brandNo, String brandName, Long price) {
        this.goodsNo = goodsNo;
        this.categoryNo = categoryNo;
        this.categoryName = categoryName;
        this.brandNo = brandNo;
        this.brandName = brandName;
        this.price = price;
    }
}