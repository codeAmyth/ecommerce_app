package com.ecommerce.ecommerce_app.service;

import com.ecommerce.ecommerce_app.model.User;
import com.ecommerce.ecommerce_app.payload.AddressDTO;
import org.springframework.stereotype.Service;

public interface AddressService {
    AddressDTO createAddress(AddressDTO addressDTO, User user);
}
