package com.category.service.impl;

import com.category.config.exception.CustomException;
import com.category.model.dto.request.BrandAddCommand;
import com.category.model.dto.request.BrandModifyCommand;
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
    public Long createBrand(BrandAddCommand addCommand) {

        var brandEntity = brandMapper.toNewEntity(addCommand);
        brandRepository.save(brandEntity);

        return brandEntity.getNo();
    }

    @Transactional
    @Override
    public Boolean modifyBrand(long brandNo, BrandModifyCommand modifyCommand) {
        validateBrand(brandNo);
        var brandEntity = brandRepository.findById(brandNo).get();
        brandEntity.setName(modifyCommand.getName());
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

    private void validateBrand(long brandNo) {
        brandRepository.findById(brandNo).orElseThrow(
                () -> new CustomException(CustomExceptionStatus.INVALID_BRAND_INFO)
        );
    }
}