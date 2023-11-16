package com.category.service.impl;

import com.category.model.dto.response.MinAndMaxPriceGoodsByCategoryResponse;
import com.category.model.dto.response.MinPriceGoodsByBrandResponse;
import com.category.model.dto.response.MinPriceGoodsByCategoryResponse;
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
    public MinAndMaxPriceGoodsByCategoryResponse getMinAndMaxPriceGoodsByCategory(String categoryName) {
        categoryService.validateCategoryByName(categoryName);
        var categoryNos = categoryService.getCategoryNosByName(categoryName);

        var maxPrices = categoryPriceRepository.findMinOrMaxPriceGoodsByCategory(categoryNos, true);
        var minPrices = categoryPriceRepository.findMinOrMaxPriceGoodsByCategory(categoryNos, false);

        return MinAndMaxPriceGoodsByCategoryResponse.builder()
                .categoryName(categoryName)
                .maxPriceGoods(maxPrices)
                .minPriceGoods(minPrices)
                .build();
    }

    @Override
    public MinPriceGoodsByCategoryResponse getCategoryMinPriceGoods() {
        var minPrices = categoryPriceRepository.findMinPriceGoodsByAllCategoryNo();
        return MinPriceGoodsByCategoryResponse.builder()
                .goodsList(minPrices)
                .build();
    }

    @Override
    public MinPriceGoodsByBrandResponse getAllCategoryMinPriceByBrand() {
        return null;
    }
}