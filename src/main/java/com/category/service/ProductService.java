package com.category.service;

import com.category.model.dto.request.ProductAddCommand;
import com.category.model.dto.request.ProductModifyCommand;

public interface ProductService {

    Long createProduct(ProductAddCommand addCommand);

    Boolean modifyProduct(long productNo, ProductModifyCommand modifyCommand);

    Boolean deleteProduct(long productNo);
}