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
        var response = categoryPriceService.getMinAndMaxPriceGoodsByCategory(categoryName);

        // then
        Assertions.assertThat(response.getCategoryName()).isEqualTo(categoryName);
        Assertions.assertThat(response.getMaxPriceGoods().get(0).getPrice()).isEqualTo(11400L);
        Assertions.assertThat(response.getMinPriceGoods().get(0).getPrice()).isEqualTo(10000L);
    }

    @Test
    void 카테고리가_없는_실패_테스트() {
        // given
        var categoryPriceService = this.categoryPriceService;
        var categoryName = "아우터 큰거";

        // when & then
        Assertions.assertThatThrownBy(() -> categoryPriceService.getMinAndMaxPriceGoodsByCategory(categoryName))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(CustomExceptionStatus.INVALID_CATEGORY_INFO.getMessage());
    }

    @Test
    void 카테고리별_최소_가격_정보조회_테스트() {
        // given
        var categoryPriceService = this.categoryPriceService;

        // when
        var response = categoryPriceService.getCategoryMinPriceGoods();

        // then
        Assertions.assertThat(response.getTotalPrice()).isEqualTo(34100);
        Assertions.assertThat(response.getGoodsList().size()).isEqualTo(8);
    }

    @Test
    void 전체카테고리_최저가_브랜드_조회_테스트() {
        // given
        var categoryPriceService = this.categoryPriceService;

        // when
        var response = categoryPriceService.getAllCategoryMinPriceByBrand();

        // then
        Assertions.assertThat(response.getTotalPrice()).isEqualTo(36100);
        Assertions.assertThat(response.getBrandName()).isEqualTo("D");
        Assertions.assertThat(response.getGoodsList().size()).isEqualTo(8);
    }
}