package com.ecommerce.ecommerce_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 5, message = "Street name must be at least 5 characters")
    private String street;

    @NotBlank
    @Size(min = 5, message = "Building name must be at least 5 characters")
    private String building;

    @NotBlank
    @Size(min = 3, message = "City name must be at least 3 characters")
    private String city;


    @NotBlank
    @Size(min = 2, message = "State name must be at least 2 characters")
    private String state;

    @NotBlank
    @Size(min = 3, message = "Country name must be at least 3 characters")
    private String country;


    @NotBlank
    @Size(min = 6, message = "Pincode must be at least 6 digits")
    private String pincode;

    @ToString.Exclude
    @ManyToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();

    public Address(Long addressId, String pincode, String country, String state, String city, String building, String street) {
        this.addressId = addressId;
        this.pincode = pincode;
        this.country = country;
        this.state = state;
        this.city = city;
        this.building = building;
        this.street = street;
    }
}
