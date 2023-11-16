package com.category.service.impl;

import com.category.model.dto.response.PriceRangeByCategoryResponse;
import com.category.repository.CategoryPriceRepository;
import com.category.service.CategoryPriceService;
import com.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CategoryPriceServiceImpl implements CategoryPriceService {

    private final CategoryService categoryService;
    private final CategoryPriceRepository categoryPriceRepository;

    @Transactional(readOnly = true)
    @Override
    public PriceRangeByCategoryResponse getPriceRangeByCategory(String categoryName) {
        categoryService.validateCategoryByName(categoryName);
        var categoryNos = categoryService.getCategoryNosByName(categoryName);

        var maxPrices = categoryPriceRepository.getProductByPrice(categoryNos, true);
        var minPrices = categoryPriceRepository.getProductByPrice(categoryNos, false);

        return PriceRangeByCategoryResponse.builder()
                .categoryName(categoryName)
                .maxPriceProducts(maxPrices)
                .minPriceProducts(minPrices)
                .build();
    }
}