package com.category.service;

import com.category.config.exception.CustomException;
import com.category.model.dto.request.BrandAddRequest;
import com.category.model.dto.request.BrandModifyRequest;
import com.category.model.enums.CustomExceptionStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BrandServiceTest {

    private final BrandService brandService;

    public BrandServiceTest(@Autowired BrandService brandService) {
        this.brandService = brandService;
    }

    @Test
    void 신규브랜드_생성_테스트() {
        // given
        var brandService = this.brandService;
        var addRequest = new BrandAddRequest();
        addRequest.setName("탑텐");

        // when
        var brandNo = brandService.createBrand(addRequest);

        // then
        Assertions.assertThat(brandNo).isNotNull();
        Assertions.assertThat(brandNo).isNotZero();
    }

    @Test
    void 신규브랜드_수정_테스트() {
        // given
        var brandService = this.brandService;
        var brandNo = 100L;
        var modifyRequest = new BrandModifyRequest();
        modifyRequest.setName("탑텐");

        // when
        var result = brandService.modifyBrand(brandNo, modifyRequest);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 신규브랜드_수정_테스트_실패() {
        // given
        var brandService = this.brandService;
        var brandNo = 1L;
        var modifyRequest = new BrandModifyRequest();
        modifyRequest.setName("탑텐");

        // when & then
        Assertions.assertThatThrownBy(() -> brandService.modifyBrand(brandNo, modifyRequest))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(CustomExceptionStatus.INVALID_BRAND_INFO.getMessage());
    }

    @Test
    void 신규브랜드_삭제_테스트() {
        // given
        var brandService = this.brandService;
        var brandNo = 100L;

        // when
        var result = brandService.deleteBrand(brandNo);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 신규브랜드_삭제_테스트_실패() {
        // given
        var brandService = this.brandService;
        var brandNo = 1L;

        // when & then
        Assertions.assertThatThrownBy(() -> brandService.deleteBrand(brandNo))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(CustomExceptionStatus.INVALID_BRAND_INFO.getMessage());
    }
}