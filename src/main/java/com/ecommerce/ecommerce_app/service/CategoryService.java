package com.ecommerce.ecommerce_app.service;
import com.ecommerce.ecommerce_app.payload.CategoryDTO;
import com.ecommerce.ecommerce_app.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    // interface for promoting the loose coupling and modularity

    CategoryResponse getAllCategories(Integer pageNumber , Integer pageSize, String sortBy, String sortOrder);

    CategoryDTO createCategory(CategoryDTO categoryDTO); // Category category

    CategoryDTO deleteCategory(long categoryId);

    CategoryDTO updateCateogry(CategoryDTO categoryDTO, Long categoryId);
}
