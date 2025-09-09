package com.example.fooddeliveryapp.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public abstract class BaseController<T, S extends com.example.fooddeliveryapp.services.BaseService<T, ?>> {
    protected final S service;

    protected BaseController(S service) { this.service = service; }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) { return ResponseEntity.of(service.create(entity)); }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable Long id) { return ResponseEntity.of(service.getById(id)); }

    @GetMapping
    public ResponseEntity<List<T>> getAll() { return ResponseEntity.of(service.getAll()); }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody T entity) { return ResponseEntity.of(service.update(entity)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { return ResponseEntity.of(service.delete(id)); }
}
