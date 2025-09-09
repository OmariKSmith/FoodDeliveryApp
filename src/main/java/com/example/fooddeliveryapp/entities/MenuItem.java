// =========================
// MenuItem.java
// =========================
package com.example.fooddeliveryapp.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    public MenuItem(Long id, String name, Double price, Restaurant restaurant) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public MenuItem(String name, Double price, Restaurant restaurant) {
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public MenuItem() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Restaurant getRestaurant() { return restaurant; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItem m)) return false;
        return Objects.equals(id, m.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
