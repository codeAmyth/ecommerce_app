package com.ecommerce.ecommerce_app.controller;

import com.ecommerce.ecommerce_app.config.AppConstants;
import com.ecommerce.ecommerce_app.payload.CategoryDTO;
import com.ecommerce.ecommerce_app.payload.CategoryResponse;
import com.ecommerce.ecommerce_app.service.CategoryService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    private CategoryService categoryService;  // this is for loose coupling

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService; //constructor injection
    }

    @GetMapping("api/public/categories")  // get request handle by rest controller
    public ResponseEntity<CategoryResponse> getCategories(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_CATEGORIES_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder
    ) {
        CategoryResponse categoryResponse =  categoryService.getAllCategories(pageNumber, pageSize, sortBy, sortOrder);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping("api/public/categories") // post request
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
       CategoryDTO savedCategoryDTO =  categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("api/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable long categoryId) {
            CategoryDTO deleteCategoryDTO = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(deleteCategoryDTO, HttpStatus.OK);
    }

    @PutMapping("api/public/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO , @PathVariable Long categoryId) {
            CategoryDTO savedCategoryDTO = categoryService.updateCateogry(categoryDTO, categoryId);
            // not using categoryResponse because its not a list its a single object
            return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);
    }
}
