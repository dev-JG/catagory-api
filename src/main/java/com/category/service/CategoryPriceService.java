package com.category.service;

import com.category.model.dto.response.MinAndMaxPriceGoodsByCategoryResponse;
import com.category.model.dto.response.MinPriceGoodsByBrandResponse;
import com.category.model.dto.response.MinPriceGoodsByCategoryResponse;

public interface CategoryPriceService {

    MinAndMaxPriceGoodsByCategoryResponse getMinAndMaxPriceGoodsByCategory(String categoryName);

    MinPriceGoodsByCategoryResponse getCategoryMinPriceGoods();

    MinPriceGoodsByBrandResponse getAllCategoryMinPriceByBrand();
}