package com.ecommerce.ecommerce_app.service;

import com.ecommerce.ecommerce_app.model.Category;

import java.util.List;

public interface CategoryService {
    // interface for promoting the loose coupling and modularity

    List<Category> getAllCategories();
    void createCategory(Category category);

    String deleteCategory(long categoryId);

    Category updateCateogry(Category category, Long categoryId);
}
