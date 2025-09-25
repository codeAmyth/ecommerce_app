package com.ecommerce.ecommerce_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @NotBlank
    @Size(min = 3, message = "Product name must contain atleast 3 characters")
    private String productName;

    @NotBlank
    @Size(min = 3, message = "Product name must contain atleast 3 characters")
    private String description;
    private String image;
    private Long quantity;
    private double discount;
    private double price;
    private double specialPrice;

    // relationship with category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
