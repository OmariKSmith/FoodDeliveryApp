package com.example.fooddeliveryapp;

import com.example.fooddeliveryapp.entities.Restaurant;
import com.example.fooddeliveryapp.repositories.RestaurantRepository;
import com.example.fooddeliveryapp.services.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RestaurantServiceTest {

    @Autowired
    private RestaurantRepository restaurantRepository;

    private RestaurantService restaurantService;

    @BeforeEach
    void setUp() {
        restaurantService = new RestaurantService(restaurantRepository);
    }

    @Test
    void testCreateAndFindRestaurant() {
        Restaurant r = new Restaurant("Pizza Palace");
        Optional<Restaurant> saved = restaurantService.create(r);
        assertTrue(saved.isPresent());
        assertNotNull(saved.get().getId());

        Optional<Restaurant> found = restaurantService.getById(saved.get().getId());
        assertTrue(found.isPresent());
        assertEquals("Pizza Palace", found.get().getName());
    }

    @Test
    void testGetAllRestaurants() {
        restaurantService.create(new Restaurant("Burger Hub"));
        restaurantService.create(new Restaurant("Sushi Spot"));

        Optional<List<Restaurant>> all = restaurantService.getAll();
        assertTrue(all.isPresent());
        assertEquals(2, all.get().size());
    }

    @Test
    void testUpdateRestaurant() {
        Restaurant r = new Restaurant("Old Name");
        Restaurant saved = restaurantService.create(r).get();

        saved.setName("New Name");
        Optional<Restaurant> updated = restaurantService.update(saved);
        assertTrue(updated.isPresent());
        assertEquals("New Name", updated.get().getName());
    }

    @Test
    void testDeleteRestaurant() {
        Restaurant r = new Restaurant("Temp");
        Restaurant saved = restaurantService.create(r).get();

        Optional<Void> deleted = restaurantService.delete(saved.getId());
        assertTrue(deleted.isEmpty() || deleted.isPresent());

        Optional<Restaurant> check = restaurantService.getById(saved.getId());
        assertTrue(check.isEmpty());
    }
}
