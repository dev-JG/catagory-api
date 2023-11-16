package com.category.repository;

import static com.category.model.entity.QProduct.product;
import static com.category.model.entity.QBrand.brand;
import static com.querydsl.jpa.JPAExpressions.select;

import com.category.model.dto.response.ProductResponse;
import com.category.model.dto.response.QProductResponse;
import com.category.model.enums.DisplayStatus;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CategoryPriceRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<ProductResponse> getProductByMaxPrice(List<Long> categoryNos) {
        return jpaQueryFactory
                .select(new QProductResponse(
                        brand.no,
                        brand.name,
                        product.price
                ))
                .from(product, brand)
                .where(product.status.eq(DisplayStatus.SALE) // 판매중인 상품만
                        .and(product.categoryNo.in(categoryNos))
                        .and(product.brandNo.eq(brand.no))
                        .and(product.price.eq(
                                select(product.price.max())
                                        .from(product)
                                        .where(product.categoryNo.in(categoryNos))
                        ))
                )
                .fetch();
    }

    public List<ProductResponse> getProductByMinPrice(List<Long> categoryNos) {
        return jpaQueryFactory
                .select(new QProductResponse(
                        brand.no,
                        brand.name,
                        product.price
                ))
                .from(product, brand)
                .where(product.status.eq(DisplayStatus.SALE) // 판매중인 상품만
                        .and(product.categoryNo.in(categoryNos))
                        .and(product.brandNo.eq(brand.no))
                        .and(product.price.eq(
                                select(product.price.min())
                                        .from(product)
                                        .where(product.categoryNo.in(categoryNos))
                        ))
                )
                .fetch();
    }
}