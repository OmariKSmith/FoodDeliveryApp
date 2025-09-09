// =========================
// Order.java
// =========================
package com.example.fooddeliveryapp.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToMany
    @JoinTable(
        name = "order_items",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    )
    private List<MenuItem> items;

    @Column(nullable = false)
    private LocalDateTime orderTime;

    @Column(nullable = false)
    private String status;

    public Order(Long id, User user, Restaurant restaurant, List<MenuItem> items, LocalDateTime orderTime, String status) {
        this.id = id;
        this.user = user;
        this.restaurant = restaurant;
        this.items = items;
        this.orderTime = orderTime;
        this.status = status;
    }

    public Order(User user, Restaurant restaurant, List<MenuItem> items, LocalDateTime orderTime, String status) {
        this.user = user;
        this.restaurant = restaurant;
        this.items = items;
        this.orderTime = orderTime;
        this.status = status;
    }

    public Order() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Restaurant getRestaurant() { return restaurant; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }

    public List<MenuItem> getItems() { return items; }
    public void setItems(List<MenuItem> items) { this.items = items; }

    public LocalDateTime getOrderTime() { return orderTime; }
    public void setOrderTime(LocalDateTime orderTime) { this.orderTime = orderTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
