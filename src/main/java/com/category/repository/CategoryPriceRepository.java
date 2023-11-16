package com.category.repository;

import static com.category.model.entity.QProduct.product;
import static com.category.model.entity.QBrand.brand;
import static com.querydsl.jpa.JPAExpressions.select;

import com.category.model.dto.response.ProductResponse;
import com.category.model.enums.DisplayStatus;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CategoryPriceRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<ProductResponse> getProductByPrice(List<Long> categoryNos, boolean isMax) {
        NumberExpression<Long> priceCondition = isMax ? product.price.max() : product.price.min();

        return jpaQueryFactory
                .select(Projections.constructor(ProductResponse.class,
                        brand.no,
                        brand.name,
                        product.price
                ))
                .from(product, brand)
                .where(product.status.eq(DisplayStatus.SALE) // 판매중인 상품만
                        .and(product.categoryNo.in(categoryNos))
                        .and(product.brandNo.eq(brand.no))
                        .and(product.price.eq(
                                select(priceCondition)
                                        .from(product)
                                        .where(product.categoryNo.in(categoryNos))
                        ))
                )
                .fetch();
    }
}