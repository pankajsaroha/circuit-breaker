package com.circuit.breaker.order.controller;

import com.circuit.breaker.order.model.Order;
import com.circuit.breaker.order.model.ResponseWrapper;
import com.circuit.breaker.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{orderNumber}")
    public ResponseWrapper<Order> findByOrderNumber (@PathVariable("orderNumber") String orderNumber) {
        return orderService.getOrderByPincode(orderNumber);
    }
}
