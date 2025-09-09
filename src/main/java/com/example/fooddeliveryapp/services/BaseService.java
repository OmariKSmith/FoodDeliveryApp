package com.example.fooddeliveryapp.services;

import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public abstract class BaseService<T, R extends org.springframework.data.jpa.repository.JpaRepository<T, Long>> {
    protected final R repository;

    protected BaseService(R repository) { this.repository = repository; }

    public Optional<T> create(T entity) { return Optional.of(repository.save(entity)); }

    public Optional<T> getById(Long id) { return repository.findById(id); }

    public Optional<List<T>> getAll() { return Optional.of(repository.findAll()); }

    public Optional<T> update(T entity) { return Optional.of(repository.save(entity)); }

    public Optional<Void> delete(Long id) {
        repository.deleteById(id);
        return Optional.empty();
    }
}
