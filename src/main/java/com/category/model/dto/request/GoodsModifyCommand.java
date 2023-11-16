package com.category.model.dto.request;

import com.category.model.entity.Goods;
import com.category.model.enums.DisplayStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
public class GoodsModifyCommand {
    private Long brandNo;
    private Long categoryNo;
    private String goodsName;
    private Long price;
    private DisplayStatus status;

    public void modifyEntity(Goods goodsEntity) {
        Optional.ofNullable(brandNo).ifPresent(goodsEntity::setBrandNo);
        Optional.ofNullable(categoryNo).ifPresent(goodsEntity::setCategoryNo);
        Optional.ofNullable(goodsName).filter(n -> !n.isEmpty()).ifPresent(goodsEntity::setGoodsName);
        Optional.ofNullable(price).ifPresent(goodsEntity::setPrice);
        Optional.ofNullable(status).ifPresent(goodsEntity::setStatus);
    }
}