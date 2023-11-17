package com.category.service;

import com.category.model.dto.command.BrandAddCommand;
import com.category.model.dto.command.BrandModifyCommand;

public interface BrandService {

    Long createBrand(BrandAddCommand addCommand);

    Boolean modifyBrand(long brandNo, BrandModifyCommand modifyCommand);

    Boolean deleteBrand(long brandNo);
}