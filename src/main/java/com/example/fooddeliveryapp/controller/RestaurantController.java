package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.entities.Restaurant;
import com.example.fooddeliveryapp.services.RestaurantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController extends BaseController<Restaurant, RestaurantService> {
    public RestaurantController(RestaurantService service) { super(service); }
}