// =========================
// Restaurant.java
// =========================
package com.example.fooddeliveryapp.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Restaurant(Long id, String name, List<MenuItem> menuItems, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.menuItems = menuItems;
        this.orders = orders;
    }

    public Restaurant(String name) { this.name = name; }

    public Restaurant() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<MenuItem> getMenuItems() { return menuItems; }
    public void setMenuItems(List<MenuItem> menuItems) { this.menuItems = menuItems; }

    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant r)) return false;
        return Objects.equals(id, r.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
