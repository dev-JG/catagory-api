package com.category.service;

import com.category.model.dto.request.GoodsAddCommand;
import com.category.model.dto.request.GoodsModifyCommand;

public interface GoodsService {

    Long createGoods(GoodsAddCommand addCommand);

    Boolean modifyGoods(long goodsNo, GoodsModifyCommand modifyCommand);

    Boolean deleteGoods(long goodsNo);
}