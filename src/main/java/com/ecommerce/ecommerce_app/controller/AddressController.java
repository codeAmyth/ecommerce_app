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
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressDTO>> getEveryAddresses() {
        List<AddressDTO> addressDTOS = addressService.getEveryAddresses();
        return new ResponseEntity<>(addressDTOS, HttpStatus.OK);
    }

    @GetMapping("/addresses/addressId/{addressId}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long addressId) {
        AddressDTO addressDTO = addressService.getAddressById(addressId);
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }

    @GetMapping("/addresses/user")
    public ResponseEntity<List<AddressDTO>> getUserAddress() {
        User user = authUtil.loggedInUser();
        List<AddressDTO> addressDTO = addressService.getUserAddress(user);
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }

    @PutMapping("/addresses/{addressId}")
    public ResponseEntity<AddressDTO> updateAddressById(@PathVariable Long addressId,
                                                        @RequestBody AddressDTO addressDTO) {
        AddressDTO updatedAddress = addressService.updateAddressById(addressId, addressDTO);
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }

    @DeleteMapping("/addresses/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long addressId) {
        String status = addressService.deleteAddress(addressId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
