package com.category.controller;

import com.category.model.dto.response.PriceRangeByCategoryResponse;
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

    @GetMapping("/price-range")
    public ResponseEntity<PriceRangeByCategoryResponse> getPriceRangeByCategory(
            @RequestParam(value = "categoryName") String categoryName) {

        return ResponseEntity.ok(
                categoryPriceService.getPriceRangeByCategory(categoryName)
        );
    }
}