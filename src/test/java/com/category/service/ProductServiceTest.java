package com.category.service;

import com.category.config.exception.CustomException;
import com.category.model.dto.request.ProductAddRequest;
import com.category.model.dto.request.ProductModifyRequest;
import com.category.model.enums.CustomExceptionStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    private final ProductService productService;

    public ProductServiceTest(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @Test
    void 신규상품_생성테스트() {
        // given
        var productService = this.productService;
        var addRequest = new ProductAddRequest();
        addRequest.setName("지오다노 아우터");
        addRequest.setBrandNo(100L);
        addRequest.setCategoryNo(10L);
        addRequest.setPrice(9500L);

        // when
        var productNo = productService.createProduct(addRequest);

        // then
        Assertions.assertThat(productNo).isNotNull();
        Assertions.assertThat(productNo).isNotZero();
    }

    @Test
    void 상품_수정_테스트() {
        // given
        var productService = this.productService;
        var productNo = 1L;
        var modifyRequest = new ProductModifyRequest();
        modifyRequest.setName("지오다노 아우터");
        modifyRequest.setBrandNo(100L);
        modifyRequest.setCategoryNo(10L);
        modifyRequest.setPrice(9500L);

        // when
        var result = productService.modifyProduct(productNo, modifyRequest);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 상품_수정_테스트_브랜드_실패() {
        // given
        var productService = this.productService;
        var productNo = 1L;
        var modifyRequest = new ProductModifyRequest();
        modifyRequest.setName("지오다노 아우터");
        modifyRequest.setBrandNo(10L);
        modifyRequest.setCategoryNo(10L);
        modifyRequest.setPrice(9500L);

        // when & then
        Assertions.assertThatThrownBy(() -> productService.modifyProduct(productNo, modifyRequest))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(CustomExceptionStatus.INVALID_BRAND_INFO.getMessage());
    }

    @Test
    void 상품_수정_테스트_카테고리_실패() {
        // given
        var productService = this.productService;
        var productNo = 1L;
        var modifyRequest = new ProductModifyRequest();
        modifyRequest.setName("지오다노 아우터");
        modifyRequest.setBrandNo(100L);
        modifyRequest.setCategoryNo(15L);
        modifyRequest.setPrice(9500L);

        // when & then
        Assertions.assertThatThrownBy(() -> productService.modifyProduct(productNo, modifyRequest))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(CustomExceptionStatus.INVALID_CATEGORY_INFO.getMessage());
    }

    @Test
    void 상품_삭제_테스트() {
        // given
        var productService = this.productService;
        var productNo = 1L;

        // when
        var result = productService.deleteProduct(productNo);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 상품_삭제_테스트_실패() {
        // given
        var productService = this.productService;
        var productNo = 1000L;

        // when & then
        Assertions.assertThatThrownBy(() -> productService.deleteProduct(productNo))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(CustomExceptionStatus.INVALID_PRODUCT_INFO.getMessage());
    }
}