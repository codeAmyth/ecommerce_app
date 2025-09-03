package com.ecommerce.ecommerce_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
