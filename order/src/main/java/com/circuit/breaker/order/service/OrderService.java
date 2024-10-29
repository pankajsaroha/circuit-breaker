package com.circuit.breaker.order.service;

import com.circuit.breaker.order.model.Order;
import com.circuit.breaker.order.model.ResponseWrapper;

public interface OrderService {
    ResponseWrapper<Order> getOrderByPincode (String orderNumber);
}
