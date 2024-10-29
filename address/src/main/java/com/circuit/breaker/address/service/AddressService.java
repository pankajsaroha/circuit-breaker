package com.circuit.breaker.address.service;

import com.circuit.breaker.address.model.Address;

public interface AddressService {
    Address getAddressByPincode (String pincode);
}
