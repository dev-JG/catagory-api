package com.category.model.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MinAndMaxPriceGoodsByCategoryResponse {
    private String categoryName;
    private List<GoodsResponse> maxPriceGoods;
    private List<GoodsResponse> minPriceGoods;
}