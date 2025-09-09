package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.entities.User;
import com.example.fooddeliveryapp.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController extends BaseController<User, UserService> {
    public UserController(UserService service) { super(service); }
}