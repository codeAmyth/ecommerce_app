package com.ecommerce.ecommerce_app.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String field;
    String fieldName;
    Long fieldId;


    public ResourceNotFoundException(String resourceName, String field, String fieldName) {
        super(String.format("%s is not founded with %s : %s", resourceName , field, fieldName)); // calls the constructor of super class
        this.resourceName = resourceName;
        this.field = field;
        this.fieldName = fieldName;
    }

    public ResourceNotFoundException(String resourceName, String field, Long fieldId) {
        super(String.format("%s is not founded with %s : %d", resourceName , field, fieldId));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldId = fieldId;
    }
}
