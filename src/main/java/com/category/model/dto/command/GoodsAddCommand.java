package com.category.model.dto.command;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GoodsAddCommand {
    private Long brandNo;
    private Long categoryNo;
    private String goodsName;
    private Long price;
}