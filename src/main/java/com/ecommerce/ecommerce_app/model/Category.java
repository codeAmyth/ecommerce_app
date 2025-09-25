package com.ecommerce.ecommerce_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "categories")// to change the name use @Entity(name="")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    // attributes of categories
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long categoryID;
    @NotBlank
    @Size(min = 5, message = "Category name must contains at least 5 characters")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

}
