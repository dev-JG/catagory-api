package com.category.service.impl;

import com.category.config.exception.CustomException;
import com.category.model.dto.request.ProductAddRequest;
import com.category.model.dto.request.ProductModifyRequest;
import com.category.model.entity.Product;
import com.category.model.enums.CustomExceptionStatus;
import com.category.model.mapper.ProductMapper;
import com.category.repository.BrandRepository;
import com.category.repository.CategoryRepository;
import com.category.repository.ProductRepository;
import com.category.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final ProductMapper productMapper;

    @Override
    public Long createProduct(ProductAddRequest addRequest) {
        validateBrand(addRequest.getBrandNo());
        validateCategory(addRequest.getCategoryNo());

        Product productEntity = productMapper.toNewEntity(addRequest);
        productRepository.save(productEntity);

        return productEntity.getNo();
    }

    @Transactional
    @Override
    public Boolean modifyProduct(long productNo, ProductModifyRequest modifyRequest) {
        validateBrand(modifyRequest.getBrandNo());
        validateCategory(modifyRequest.getCategoryNo());
        validateProduct(productNo);

        var productEntity = productRepository.findById(productNo).get();
        modifyRequest.modifyEntity(productEntity);
        productRepository.save(productEntity);

        return true;
    }

    @Transactional
    @Override
    public Boolean deleteProduct(long productNo) {
        validateProduct(productNo);
        productRepository.deleteById(productNo);
        return true;
    }

    private void validateProduct(long productNo) {
        productRepository.findById(productNo).orElseThrow(
                () -> new CustomException(CustomExceptionStatus.INVALID_PRODUCT_INFO)
        );
    }

    private void validateBrand(long brandNo) {
        brandRepository.findById(brandNo).orElseThrow(
                () -> new CustomException(CustomExceptionStatus.INVALID_BRAND_INFO)
        );
    }

    private void validateCategory(long categoryNo) {
        categoryRepository.findById(categoryNo).orElseThrow(
                () -> new CustomException(CustomExceptionStatus.INVALID_CATEGORY_INFO)
        );
    }
}