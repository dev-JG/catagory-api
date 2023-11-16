package com.category.service;

import com.category.model.dto.response.PriceRangeByCategoryResponse;

public interface CategoryPriceService {

    PriceRangeByCategoryResponse getPriceRangeByCategory(String categoryName);
}