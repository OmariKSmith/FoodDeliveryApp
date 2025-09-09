package com.example.fooddeliveryapp.repositories;

import com.example.fooddeliveryapp.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {}
