package com.category.service.impl;

import com.category.config.exception.CustomException;
import com.category.model.entity.Category;
import com.category.model.enums.CustomExceptionStatus;
import com.category.repository.CategoryRepository;
import com.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Long> getCategoryNosByName(String categoryName) {
        return categoryRepository.findCategoryByName(categoryName)
                .stream()
                .map(Category::getNo)
                .collect(Collectors.toList());
    }

    public void validateCategoryByName(String categoryName) {
        if (categoryRepository.findCategoryByName(categoryName).isEmpty()) {
            throw new CustomException(CustomExceptionStatus.INVALID_CATEGORY_INFO);
        }
    }
}