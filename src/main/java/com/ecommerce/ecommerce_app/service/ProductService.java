package com.ecommerce.ecommerce_app.service;

import com.ecommerce.ecommerce_app.model.Product;
import com.ecommerce.ecommerce_app.payload.ProductDTO;
import com.ecommerce.ecommerce_app.payload.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, ProductDTO productDTO);

    ProductResponse getAllProducts();

    ProductResponse searchByCategory(Long categoryId);

    ProductResponse searchByKeywords(String keywords);

    ProductDTO updateProduct(Long productId, ProductDTO product);

    ProductDTO deleteProduct(Long productId);

    ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException;
}

