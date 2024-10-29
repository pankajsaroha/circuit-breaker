package com.circuit.breaker.order.service.impl;

import com.circuit.breaker.order.model.Address;
import com.circuit.breaker.order.model.Order;
import com.circuit.breaker.order.model.ResponseWrapper;
import com.circuit.breaker.order.repository.OrderRepository;
import com.circuit.breaker.order.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVICE_NAME = "order-service";
    private static final String ADDRESS_SERVICE_URL = "http://localhost:8081/addresses/";

    @Override
    @CircuitBreaker(name = SERVICE_NAME,  fallbackMethod = "fallbackMethod")
    public ResponseWrapper<Order> getOrderByPincode(String orderNumber) {
        Order order = orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new RuntimeException("Order not found " + orderNumber));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Address> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Address> response = restTemplate.exchange(
                (ADDRESS_SERVICE_URL + order.getPincode()), HttpMethod.GET, entity, Address.class
        );
        Address address = response.getBody();
        if (address != null) {
            order.setShippingCity(address.getCity());
            order.setShippingState(address.getState());
        }
        return new ResponseWrapper<>(order);
    }

    private ResponseWrapper<Order> fallbackMethod (Exception e) {
        return new ResponseWrapper<>("Address service is not responding");
    }
}
