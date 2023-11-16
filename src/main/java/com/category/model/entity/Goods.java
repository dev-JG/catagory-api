package com.category.model.entity;

import com.category.model.enums.DisplayStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Setter
@Getter
@DynamicUpdate
@NoArgsConstructor
@Table(name = "goods")
@Entity
public class Goods extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_no")
    private Long goodsNo;

    @Column(name = "brand_no", nullable = false)
    private Long brandNo;

    @Column(name = "category_no", nullable = false)
    private Long categoryNo;

    @Column(name = "goods_name", nullable = false)
    private String goodsName;

    @Column(name = "price")
    private Long price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DisplayStatus status;
}