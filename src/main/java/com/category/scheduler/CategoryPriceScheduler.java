package com.category.scheduler;

import com.category.model.entity.CategoryMinGoods;
import com.category.repository.CategoryMinGoodsRepository;
import com.category.repository.CategoryPriceRepository;
import com.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class CategoryPriceScheduler {

    private final CategoryService categoryService;
    private final CategoryMinGoodsRepository categoryMinGoodsRepository;
    private final CategoryPriceRepository categoryPriceRepository;

    /**
     * 카테고리별 최저가 데이터 5분 주기 갱신
     * */
    @PostConstruct
    @Scheduled(cron = "*/5 * * * *")
    public void updateCategoryMinGoodsData() {
        categoryService.getAllCategoryNos().forEach(categoryNo -> {
            var goodsResponse = categoryPriceRepository.findMinPriceGoodsByCategoryNo(categoryNo);
            categoryMinGoodsRepository.findById(goodsResponse.getCategoryNo()).ifPresentOrElse(
                    entity -> {
                        entity.setGoodsNo(goodsResponse.getGoodsNo());
                        entity.setBrandNo(goodsResponse.getBrandNo());
                        entity.setLastUpdatedDate(LocalDateTime.now());
                        categoryMinGoodsRepository.save(entity);
                    },
                    () -> {
                        CategoryMinGoods categoryMinGoodsEntity = new CategoryMinGoods(categoryNo, goodsResponse.getBrandNo(), goodsResponse.getGoodsNo());
                        categoryMinGoodsRepository.save(categoryMinGoodsEntity);
                    }
            );
        });
    }
}