package com.ecommerce.ecommerce_app.controller;

import com.ecommerce.ecommerce_app.model.Category;
import com.ecommerce.ecommerce_app.service.CategoryService;
import com.ecommerce.ecommerce_app.service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;  // this is for loose coupling

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService; //constructor injection
    }

    @GetMapping("api/public/categories")  // get request handle by rest controller
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories =  categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("api/public/categories") // post request
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category added successful", HttpStatus.CREATED);
    }

    @DeleteMapping("api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable long categoryId) {
        try {
            String status = categoryService.deleteCategory(categoryId);
            //return new ResponseEntity<>(status , HttpStatus.OK); this can be use as
           // return ResponseEntity.ok(status);// or we can also use
            return ResponseEntity.status(HttpStatus.OK).body(status); // but the basic format is first one

        }catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("api/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category , @PathVariable Long categoryId) {
        try{
            Category savedCategory = categoryService.updateCateogry(category, categoryId);
            return new ResponseEntity<>("Category with category id: " + categoryId + " updated", HttpStatus.OK);
        }catch (ResponseStatusException e) {
            return new  ResponseEntity<>(e.getReason() , e.getStatusCode());
        }
    }
}
