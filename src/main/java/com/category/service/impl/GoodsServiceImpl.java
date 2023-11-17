package com.category.service.impl;

import com.category.config.exception.CustomException;
import com.category.model.dto.command.GoodsAddCommand;
import com.category.model.dto.command.GoodsModifyCommand;
import com.category.model.entity.Goods;
import com.category.model.enums.CustomExceptionStatus;
import com.category.model.mapper.GoodsMapper;
import com.category.repository.BrandRepository;
import com.category.repository.CategoryRepository;
import com.category.repository.GoodsRepository;
import com.category.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final CategoryRepository categoryRepository;
    private final GoodsRepository goodsRepository;
    private final BrandRepository brandRepository;
    private final GoodsMapper goodsMapper;

    @Override
    public Long createGoods(GoodsAddCommand addCommand) {
        validateBrand(addCommand.getBrandNo());
        validateCategory(addCommand.getCategoryNo());

        Goods goodsEntity = goodsMapper.toNewEntity(addCommand);
        goodsRepository.save(goodsEntity);

        return goodsEntity.getGoodsNo();
    }

    @Transactional
    @Override
    public Boolean modifyGoods(long goodsNo, GoodsModifyCommand modifyCommand) {
        validateBrand(modifyCommand.getBrandNo());
        validateCategory(modifyCommand.getCategoryNo());
        validateGoods(goodsNo);

        var goodsEntity = goodsRepository.findById(goodsNo).get();
        modifyCommand.modifyEntity(goodsEntity);
        goodsRepository.save(goodsEntity);

        return true;
    }

    @Transactional
    @Override
    public Boolean deleteGoods(long goodsNo) {
        validateGoods(goodsNo);
        goodsRepository.deleteById(goodsNo);
        return true;
    }

    private void validateGoods(long goodsNo) {
        goodsRepository.findById(goodsNo).orElseThrow(
                () -> new CustomException(CustomExceptionStatus.INVALID_GOODS_INFO)
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