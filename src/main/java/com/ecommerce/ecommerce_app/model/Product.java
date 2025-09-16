package com.ecommerce.ecommerce_app.model;

import jakarta.persistence.*;
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
    private String productName;
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
