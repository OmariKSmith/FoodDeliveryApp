package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.entities.Order;
import com.example.fooddeliveryapp.services.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController extends BaseController<Order, OrderService> {
    public OrderController(OrderService service) { super(service); }
}