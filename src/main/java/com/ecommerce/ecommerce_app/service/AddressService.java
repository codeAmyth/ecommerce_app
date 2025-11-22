package com.ecommerce.ecommerce_app.service;

import com.ecommerce.ecommerce_app.model.Address;
import com.ecommerce.ecommerce_app.model.User;
import com.ecommerce.ecommerce_app.payload.AddressDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {
    AddressDTO createAddress(AddressDTO addressDTO, User user);

    List<AddressDTO> getEveryAddresses();

    AddressDTO getAddressById(Long addressId);

    List<AddressDTO> getUserAddress(User user);

    AddressDTO updateAddressById(Long addressId, AddressDTO addressDTO);

    String deleteAddress(Long addressId);
}

