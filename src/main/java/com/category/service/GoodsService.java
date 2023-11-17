package com.category.service;

import com.category.model.dto.command.GoodsAddCommand;
import com.category.model.dto.command.GoodsModifyCommand;

public interface GoodsService {

    Long createGoods(GoodsAddCommand addCommand);

    Boolean modifyGoods(long goodsNo, GoodsModifyCommand modifyCommand);

    Boolean deleteGoods(long goodsNo);
}