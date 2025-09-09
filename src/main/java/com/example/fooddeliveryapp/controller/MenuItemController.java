package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.entities.MenuItem;
import com.example.fooddeliveryapp.services.MenuItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController extends BaseController<MenuItem, MenuItemService> {
    public MenuItemController(MenuItemService service) { super(service); }
}