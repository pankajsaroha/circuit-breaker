package com.circuit.breaker.address.service.impl;

import com.circuit.breaker.address.model.Address;
import com.circuit.breaker.address.repository.AddressRepository;
import com.circuit.breaker.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address getAddressByPincode(String pincode) {
        return addressRepository.findByPincode(pincode)
                .orElseThrow(() -> new RuntimeException("Address not found " + pincode));
    }
}
