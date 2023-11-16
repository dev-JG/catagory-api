package com.category.service;

import com.category.config.exception.CustomException;
import com.category.model.dto.request.GoodsAddCommand;
import com.category.model.dto.request.GoodsModifyCommand;
import com.category.model.enums.CustomExceptionStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoodsServiceTest {

    private final GoodsService goodsService;

    public GoodsServiceTest(@Autowired GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Test
    void 신규상품_생성테스트() {
        // given
        var goodsService = this.goodsService;
        var addRequest = new GoodsAddCommand();
        addRequest.setGoodsName("지오다노 아우터");
        addRequest.setBrandNo(120L);
        addRequest.setCategoryNo(10L);
        addRequest.setPrice(9500L);

        // when
        var goodsNo = goodsService.createGoods(addRequest);

        // then
        Assertions.assertThat(goodsNo).isNotNull();
        Assertions.assertThat(goodsNo).isNotZero();
    }

    @Test
    void 상품_수정_테스트() {
        // given
        var goodsService = this.goodsService;
        var goodsNo = 1L;
        var modifyRequest = new GoodsModifyCommand();
        modifyRequest.setGoodsName("지오다노 아우터");
        modifyRequest.setBrandNo(120L);
        modifyRequest.setCategoryNo(10L);
        modifyRequest.setPrice(9500L);

        // when
        var result = goodsService.modifyGoods(goodsNo, modifyRequest);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 상품_수정_테스트_브랜드_실패() {
        // given
        var goodsService = this.goodsService;
        var goodsNo = 1L;
        var modifyRequest = new GoodsModifyCommand();
        modifyRequest.setGoodsName("지오다노 아우터");
        modifyRequest.setBrandNo(10L);
        modifyRequest.setCategoryNo(10L);
        modifyRequest.setPrice(9500L);

        // when & then
        Assertions.assertThatThrownBy(() -> goodsService.modifyGoods(goodsNo, modifyRequest))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(CustomExceptionStatus.INVALID_BRAND_INFO.getMessage());
    }

    @Test
    void 상품_수정_테스트_카테고리_실패() {
        // given
        var goodsService = this.goodsService;
        var goodsNo = 1L;
        var modifyRequest = new GoodsModifyCommand();
        modifyRequest.setGoodsName("지오다노 아우터");
        modifyRequest.setBrandNo(120L);
        modifyRequest.setCategoryNo(15L);
        modifyRequest.setPrice(9500L);

        // when & then
        Assertions.assertThatThrownBy(() -> goodsService.modifyGoods(goodsNo, modifyRequest))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(CustomExceptionStatus.INVALID_CATEGORY_INFO.getMessage());
    }

    @Test
    void 상품_삭제_테스트() {
        // given
        var goodsService = this.goodsService;
        var goodsNo = 1L;

        // when
        var result = goodsService.deleteGoods(goodsNo);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 상품_삭제_테스트_실패() {
        // given
        var goodsService = this.goodsService;
        var goodsNo = 1000L;

        // when & then
        Assertions.assertThatThrownBy(() -> goodsService.deleteGoods(goodsNo))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(CustomExceptionStatus.INVALID_GOODS_INFO.getMessage());
    }
}