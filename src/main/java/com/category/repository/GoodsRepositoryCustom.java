package com.category.repository;

import com.category.model.dto.response.BrandSummaryResponse;
import com.category.model.dto.response.GoodsResponse;
import com.category.model.enums.DisplayStatus;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.category.model.entity.QBrand.brand;
import static com.category.model.entity.QCategory.category;
import static com.category.model.entity.QGoods.goods;

@RequiredArgsConstructor
@Repository
public class GoodsRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public BrandSummaryResponse findMinGoodsTotalPriceByBrand() {
        return jpaQueryFactory
                .select(Projections.constructor(BrandSummaryResponse.class,
                        goods.brandNo,
                        brand.brandName,
                        goods.price.sum()
                ))
                .from(goods)
                .join(brand).on(goods.brandNo.eq(brand.brandNo))
                .groupBy(goods.brandNo)
                .orderBy(goods.price.sum().asc())
                .fetchFirst();
    }

    public List<GoodsResponse> findGoodsByBrandNo(Long brandNo) {
        return jpaQueryFactory
                .select(Projections.constructor(GoodsResponse.class,
                        goods.goodsNo,
                        category.categoryNo,
                        category.categoryName,
                        brand.brandNo,
                        brand.brandName,
                        goods.price
                ))
                .from(goods)
                .join(brand).on(goods.brandNo.eq(brand.brandNo))
                .join(category).on(goods.categoryNo.eq(category.categoryNo))
                .where(goods.status.eq(DisplayStatus.SALE)
                        .and(goods.brandNo.eq(brandNo))
                )
                .fetch();
    }
}