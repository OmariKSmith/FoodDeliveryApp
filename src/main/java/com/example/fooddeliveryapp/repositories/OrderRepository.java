package com.example.fooddeliveryapp.repositories;

import com.example.fooddeliveryapp.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
