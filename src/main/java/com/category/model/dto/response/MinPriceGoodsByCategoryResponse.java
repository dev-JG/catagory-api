package com.category.model.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MinPriceGoodsByCategoryResponse {
    private Long totalPrice;
    private List<GoodsResponse> goodsList;

    public Long getTotalPrice() {
        return goodsList.stream()
                .map(GoodsResponse::getPrice)
                .reduce(0L, Long::sum);
    }
}
