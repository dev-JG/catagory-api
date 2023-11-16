package com.category.model.dto.request;

import com.category.model.entity.Product;
import com.category.model.enums.DisplayStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
public class ProductModifyRequest {
    private Long brandNo;
    private Long categoryNo;
    private String name;
    private Long price;
    private DisplayStatus status;

    public void modifyEntity(Product productEntity) {
        Optional.ofNullable(brandNo).ifPresent(productEntity::setBrandNo);
        Optional.ofNullable(categoryNo).ifPresent(productEntity::setCategoryNo);
        Optional.ofNullable(name).filter(n -> !n.isEmpty()).ifPresent(productEntity::setName);
        Optional.ofNullable(price).ifPresent(productEntity::setPrice);
        Optional.ofNullable(status).ifPresent(productEntity::setStatus);
    }
}