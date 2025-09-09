package com.example.fooddeliveryapp.services;

import com.example.fooddeliveryapp.entities.MenuItem;
import com.example.fooddeliveryapp.repositories.MenuItemRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService extends BaseService<MenuItem, MenuItemRepository> {
    public MenuItemService(MenuItemRepository repository) { super(repository); }
}
