package com.ecommerce.ecommerce_app.service;

import com.ecommerce.ecommerce_app.exception.APIException;
import com.ecommerce.ecommerce_app.exception.ResourceNotFoundException;
import com.ecommerce.ecommerce_app.model.Category;
import com.ecommerce.ecommerce_app.payload.CategoryDTO;
import com.ecommerce.ecommerce_app.payload.CategoryResponse;
import com.ecommerce.ecommerce_app.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategories() {
        List<Category> myCategories = new ArrayList<>(); // creating list of categories
        myCategories = categoryRepository.findAll();
        if(myCategories.isEmpty()) { // adding vallidations
            throw new APIException("No category founded, please add new Categories");
        }

        // create list of dto objects and map it

        List<CategoryDTO> categoryDTOS = myCategories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList(); // mapped every object with categoryDTO
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);  // create response that will take the dto responses
        //return the category response

        return categoryResponse; // changed from returning list to returning categoryresoponse
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if(savedCategory != null) {
            throw new APIException("Category with name "+category.getCategoryName() + " already exist." );
        }
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId" , categoryId));

        categoryRepository.delete(category);
        return "Category with category id: " + categoryId + " deleted successfully";
    }

    @Override
    public Category updateCateogry(Category category, Long categoryId) {
        Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);

        Category savedCategory = savedCategoryOptional
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId" , categoryId));

        category.setCategoryID(categoryId);

        savedCategory = categoryRepository.save(category);
        return savedCategory;

    }
}
