package com.category.controller;

import com.category.model.dto.response.MinAndMaxPriceGoodsByCategoryResponse;
import com.category.model.dto.response.MinPriceGoodsByBrandResponse;
import com.category.model.dto.response.MinPriceGoodsByCategoryResponse;
import com.category.service.CategoryPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories/price")
public class CategoryPriceController {

    private final CategoryPriceService categoryPriceService;

    @GetMapping("/goods/max-min")
    public ResponseEntity<MinAndMaxPriceGoodsByCategoryResponse> getMinAndMaxPriceGoodsByCategory(
            @RequestParam(value = "categoryName") String categoryName) {

        return ResponseEntity.ok()
                .body(categoryPriceService.getMinAndMaxPriceGoodsByCategory(categoryName));
    }

    @GetMapping("/goods/min")
    public ResponseEntity<MinPriceGoodsByCategoryResponse> getCategoryMinPriceGoods() {

        return ResponseEntity.ok()
                .body(categoryPriceService.getCategoryMinPriceGoods());
    }

    @GetMapping("/brand/min")
    public ResponseEntity<MinPriceGoodsByBrandResponse> getAllCategoryMinPriceByBrand() {

        return ResponseEntity.ok()
                .body(categoryPriceService.getAllCategoryMinPriceByBrand());
    }
}