package com.category.service;

import com.category.config.exception.CustomException;
import com.category.model.enums.CustomExceptionStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryPriceServiceTest {

    private final CategoryPriceService categoryPriceService;

    public CategoryPriceServiceTest(@Autowired CategoryPriceService categoryPriceService) {
        this.categoryPriceService = categoryPriceService;
    }

    @Test
    void 카테고리이름_기준_최대_최소_가격_정보조회_테스트() {
        // given
        var categoryPriceService = this.categoryPriceService;
        var categoryName = "상의";

        // when
        var response = categoryPriceService.getPriceRangeByCategory(categoryName);

        // then
        Assertions.assertThat(response.getCategoryName()).isEqualTo(categoryName);
        Assertions.assertThat(response.getMaxPriceProducts().get(0).getPrice()).isEqualTo(11400L);
        Assertions.assertThat(response.getMinPriceProducts().get(0).getPrice()).isEqualTo(10000L);
    }

    @Test
    void 카테고리가_없는_실패_테스트() {
        // given
        var categoryPriceService = this.categoryPriceService;
        var categoryName = "아우터 큰거";

        // when & then
        Assertions.assertThatThrownBy(() -> categoryPriceService.getPriceRangeByCategory(categoryName))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(CustomExceptionStatus.INVALID_CATEGORY_INFO.getMessage());
    }
}