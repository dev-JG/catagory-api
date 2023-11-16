package com.category.service;

import com.category.model.dto.request.ProductAddRequest;
import com.category.model.dto.request.ProductModifyRequest;

public interface ProductService {

    Long createProduct(ProductAddRequest addRequest);

    Boolean modifyProduct(long productNo, ProductModifyRequest modifyRequest);

    Boolean deleteProduct(long productNo);
}