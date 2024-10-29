package com.circuit.breaker.address.controller;

import com.circuit.breaker.address.model.Address;
import com.circuit.breaker.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/{pincode}")
    public Address getAddressByPincode (@PathVariable("pincode") String pincode) {
        return addressService.getAddressByPincode(pincode);
    }
}
