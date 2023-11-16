package com.category.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@DynamicUpdate
@NoArgsConstructor
@Table(name = "category_min_goods")
@Entity
public class CategoryMinGoods {

    @Id
    @Column(name = "category_no")
    private Long categoryNo;

    @Column(name = "brand_no", nullable = false)
    private Long brandNo;

    @Column(name = "goods_no", nullable = false)
    private Long goodsNo;

    @Column(name = "last_updated_date")
    private LocalDateTime lastUpdatedDate;

    public CategoryMinGoods(Long categoryNo, Long brandNo, Long goodsNo) {
        this.categoryNo = categoryNo;
        this.brandNo = brandNo;
        this.goodsNo = goodsNo;
        this.lastUpdatedDate = LocalDateTime.now();
    }
}