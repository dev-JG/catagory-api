package com.category.service.impl;

import com.category.model.dto.response.GoodsResponse;
import com.category.model.dto.response.MinAndMaxPriceGoodsByCategoryResponse;
import com.category.model.dto.response.MinPriceGoodsByCategoryResponse;
import com.category.repository.CategoryPriceRepository;
import com.category.service.CategoryPriceService;
import com.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


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
        var allCategoryNos = categoryService.getAllCategoryNos();
        List<GoodsResponse> minPrices = allCategoryNos.stream()
                .map(categoryPriceRepository::findMinPriceGoodsByCategoryNo)
                .collect(Collectors.toList());

        return MinPriceGoodsByCategoryResponse.builder()
                .goodsList(minPrices)
                .build();
    }
}