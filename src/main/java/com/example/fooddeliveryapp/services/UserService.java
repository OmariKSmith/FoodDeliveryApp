package com.example.fooddeliveryapp.services;


import com.example.fooddeliveryapp.entities.User;
import com.example.fooddeliveryapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserRepository> {
    public UserService(UserRepository repository) { super(repository); }
}

