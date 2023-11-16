package com.category.service;

import java.util.List;

public interface CategoryService {

    List<Long> getCategoryNosByName(String categoryName);

    void validateCategoryByName(String categoryName);
}