package com.circuit.breaker.address.configuration;

import com.circuit.breaker.address.model.Address;
import com.circuit.breaker.address.repository.AddressRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataSetup {

    @Autowired
    private AddressRepository addressRepository;

    /**
     * PostConstruct will be called just after the initialization of bean properties
     */
    @PostConstruct
    public void setupData () {
        addressRepository.saveAll(Arrays.asList(
                Address.builder().id(1).pincode("247554").city("Deoband").state("Uttar Pradesh").build(),
                Address.builder().id(2).pincode("247001").city("Saharanpur").state("Uttar Pradesh").build(),
                Address.builder().id(3).pincode("201318").city("Noida").state("Uttar Pradesh").build()
        ));
    }
}
