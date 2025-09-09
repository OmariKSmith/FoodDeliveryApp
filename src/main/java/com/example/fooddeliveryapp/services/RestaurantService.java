package com.example.fooddeliveryapp.services;

import com.example.fooddeliveryapp.entities.Restaurant;
import com.example.fooddeliveryapp.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService extends BaseService<Restaurant, RestaurantRepository> {
    public RestaurantService(RestaurantRepository repository) { super(repository); }
}
