package com.ecommerce.ecommerce_app.service;

import com.ecommerce.ecommerce_app.model.Product;
import com.ecommerce.ecommerce_app.payload.ProductDTO;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);
}
