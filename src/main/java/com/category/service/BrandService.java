package com.category.service;

import com.category.model.dto.request.BrandAddRequest;
import com.category.model.dto.request.BrandModifyRequest;

public interface BrandService {

    Long createBrand(BrandAddRequest addRequest);

    Boolean modifyBrand(long brandNo, BrandModifyRequest modifyRequest);

    Boolean deleteBrand(long brandNo);
}