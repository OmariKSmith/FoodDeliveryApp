package com.example.fooddeliveryapp.services;

import com.example.fooddeliveryapp.entities.Order;
import com.example.fooddeliveryapp.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<Order, OrderRepository> {
    public OrderService(OrderRepository repository) { super(repository); }
}
