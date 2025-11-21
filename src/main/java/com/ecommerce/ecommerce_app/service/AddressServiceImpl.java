package com.ecommerce.ecommerce_app.service;

import com.ecommerce.ecommerce_app.exception.ResourceNotFoundException;
import com.ecommerce.ecommerce_app.model.Address;
import com.ecommerce.ecommerce_app.model.User;
import com.ecommerce.ecommerce_app.payload.AddressDTO;
import com.ecommerce.ecommerce_app.repositories.AddressRepository;
import com.ecommerce.ecommerce_app.repositories.UserRepository;
import com.ecommerce.ecommerce_app.util.AuthUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthUtil authUtil;

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO, User user) {
        Address address = modelMapper.map(addressDTO, Address.class);
        address.setUser(user);
        List<Address> addressesList = user.getAddresses();
        addressesList.add(address);
        user.setAddresses(addressesList);
        Address savedAddress = addressRepo.save(address);
        return modelMapper.map(savedAddress, AddressDTO.class);
    }

    @Override
    public List<AddressDTO> getEveryAddresses() {
        List<Address> addressDTOS = addressRepo.findAll();
        return addressDTOS.stream().map(address ->
            modelMapper.map(address, AddressDTO.class)
        ).toList();
    }

    @Override
    public AddressDTO getAddressById(Long addressId) {
        Address address = addressRepo.findById(addressId).orElseThrow(() ->
             new ResourceNotFoundException("Address", "addressID", addressId));
        return modelMapper.map(address, AddressDTO.class);
    }
}

