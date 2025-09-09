// =========================
// User.java
// =========================
package com.example.fooddeliveryapp.entities;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    // Optional: One user can have multiple orders
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    // Full constructor
    public User(Long id, String username, String password, List<Order> orders) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.orders = orders;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
