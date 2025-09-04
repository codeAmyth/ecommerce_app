package com.ecommerce.ecommerce_app.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO { // category dto is used to encapsulate and transfer data related to categories from client to server
    // earlier we were using model
    // adding like model
    private Long categoryId;
    private String categoryName;
}
