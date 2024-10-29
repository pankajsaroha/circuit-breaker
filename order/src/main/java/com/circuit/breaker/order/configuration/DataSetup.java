package com.circuit.breaker.order.configuration;

import com.circuit.breaker.order.model.Order;
import com.circuit.breaker.order.repository.OrderRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataSetup {

    @Autowired
    private OrderRepository orderRepository;

    @PostConstruct
    public void setupData () {
        orderRepository.saveAll(Arrays.asList(
                Order.builder().id(1).orderNumber("0c70c0c2").pincode("247554").build(),
                Order.builder().id(2).orderNumber("7f8f9f15").pincode("247001").build(),
                Order.builder().id(3).orderNumber("394627b2").pincode("201318").build()
        ));
    }
}
