package com.category.repository;

import static com.category.model.entity.QGoods.goods;
import static com.category.model.entity.QBrand.brand;
import static com.category.model.entity.QCategory.category;
import static com.querydsl.jpa.JPAExpressions.select;

import com.category.model.dto.response.GoodsResponse;
import com.category.model.enums.DisplayStatus;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.SubQueryExpression;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CategoryPriceRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<GoodsResponse> findMinOrMaxPriceGoodsByCategory(List<Long> categoryNos, boolean isMax) {
        NumberExpression<Long> priceCondition = isMax ? goods.price.max() : goods.price.min();

        return jpaQueryFactory
                .select(Projections.constructor(GoodsResponse.class,
                        brand.brandNo,
                        brand.brandName,
                        goods.price
                ))
                .from(goods)
                .join(brand).on(goods.brandNo.eq(brand.brandNo))
                .where(goods.status.eq(DisplayStatus.SALE) // 판매중인 상품만
                        .and(goods.categoryNo.in(categoryNos))
                        .and(goods.price.eq(
                                select(priceCondition)
                                        .from(goods)
                                        .where(goods.categoryNo.in(categoryNos))
                        ))
                )
                .fetch();
    }

    public GoodsResponse findMinPriceGoodsByCategoryNo(Long categoryNo) {
        SubQueryExpression<Long> minPriceSubQuery = JPAExpressions
                .select(goods.price.min())
                .from(goods)
                .where(goods.categoryNo.eq(category.categoryNo));

        return jpaQueryFactory
                .select(Projections.constructor(GoodsResponse.class,
                        category.categoryName,
                        brand.brandNo,
                        brand.brandName,
                        goods.price
                ))
                .from(goods)
                .join(brand).on(goods.brandNo.eq(brand.brandNo))
                .join(category).on(goods.categoryNo.eq(category.categoryNo))
                .where(goods.status.eq(DisplayStatus.SALE)
                        .and(goods.categoryNo.in(categoryNo))
                        .and(goods.price.eq(minPriceSubQuery))
                )
                .fetchFirst();
    }
}