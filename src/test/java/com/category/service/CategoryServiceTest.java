package com.category.service;

import com.category.config.exception.CustomException;
import com.category.model.enums.CustomExceptionStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryServiceTest {

    private final CategoryService categoryService;

    public CategoryServiceTest(@Autowired CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Test
    void 카테고리_이름_조회_테스트() {
        // given
        var categoryService = this.categoryService;
        var categoryName = "상의";

        // when
        var categoryNos = categoryService.getCategoryNosByName(categoryName);

        // then
        Assertions.assertThat(categoryNos).isNotNull();
    }

    @Test
    void 카테고리_유효성체크_성공() {
        // given
        var categoryService = this.categoryService;
        var categoryName = "상의";

        // when
        categoryService.validateCategoryByName(categoryName);

        // then
        Assertions.assertThatNoException().isThrownBy(() -> System.out.println("OK"));
    }

    @Test
    void 카테고리_유효성체크_실패() {
        // given
        var categoryService = this.categoryService;
        var categoryName = "아우터 큰거";

        // when & then
        Assertions.assertThatThrownBy(() -> categoryService.validateCategoryByName(categoryName))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(CustomExceptionStatus.INVALID_CATEGORY_INFO.getMessage());
    }
}
