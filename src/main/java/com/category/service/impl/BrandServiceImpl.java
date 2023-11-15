package com.category.service.impl;

import com.category.config.exception.CustomException;
import com.category.model.dto.request.BrandAddRequest;
import com.category.model.dto.request.BrandModifyRequest;
import com.category.model.enums.CustomExceptionStatus;
import com.category.model.mapper.BrandMapper;
import com.category.repository.BrandRepository;
import com.category.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public Long createBrand(BrandAddRequest addRequest) {

        var brandEntity = brandMapper.toNewEntity(addRequest);
        brandRepository.save(brandEntity);

        return brandEntity.getNo();
    }

    @Transactional
    @Override
    public Boolean modifyBrand(long brandNo, BrandModifyRequest modifyRequest) {
        validateBrand(brandNo);
        var brandEntity = brandRepository.findById(brandNo).get();
        brandEntity.setName(modifyRequest.getName());
        brandRepository.save(brandEntity);

        return true;
    }

    @Transactional
    @Override
    public Boolean deleteBrand(long brandNo) {
        validateBrand(brandNo);
        brandRepository.deleteById(brandNo);

        return true;
    }

    private boolean validateBrand(long brandNo) {
        brandRepository.findById(brandNo).orElseThrow(
                () -> new CustomException(CustomExceptionStatus.INVALID_BRAND_INFO)
        );
        return true;
    }
}