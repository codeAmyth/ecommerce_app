package com.ecommerce.ecommerce_app.repositories;

import com.ecommerce.ecommerce_app.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Long> {
    Category findByCategoryName(@NotBlank @Size(min = 5, message = "Category name must contains at least 5 characters") String categoryName);
}
