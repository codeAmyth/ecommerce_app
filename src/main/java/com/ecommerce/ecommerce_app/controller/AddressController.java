package com.ecommerce.ecommerce_app.controller;

import com.ecommerce.ecommerce_app.model.User;
import com.ecommerce.ecommerce_app.payload.AddressDTO;
import com.ecommerce.ecommerce_app.repositories.AddressRepository;
import com.ecommerce.ecommerce_app.service.AddressService;
import com.ecommerce.ecommerce_app.util.AuthUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AuthUtil authUtil;

    @PostMapping("/addresses")
    public ResponseEntity<AddressDTO> addAddress(@Valid @RequestBody AddressDTO addressDTO) {
        User user = authUtil.loggedInUser();
        AddressDTO addressDTO1 = addressService.createAddress(addressDTO, user);
        return new ResponseEntity<>(addressDTO1, HttpStatus.CREATED);
    }
}
