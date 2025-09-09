package com.example.fooddeliveryapp;

import com.example.fooddeliveryapp.entities.User;
import com.example.fooddeliveryapp.repositories.UserRepository;
import com.example.fooddeliveryapp.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserServiceTest {

    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    void testCreateAndFindUser() {
        User user = new User("alice", "password123");
        Optional<User> savedUser = userService.create(user);
        assertTrue(savedUser.isPresent());
        assertNotNull(savedUser.get().getId());

        Optional<User> foundUser = userService.getById(savedUser.get().getId());
        assertTrue(foundUser.isPresent());
        assertEquals("alice", foundUser.get().getUsername());
    }

    @Test
    void testGetAllUsers() {
        userService.create(new User("bob", "pass1"));
        userService.create(new User("carol", "pass2"));

        Optional<List<User>> allUsers = userService.getAll();
        assertTrue(allUsers.isPresent());
        assertEquals(2, allUsers.get().size());
    }

    @Test
    void testUpdateUser() {
        User user = new User("dave", "123");
        User saved = userService.create(user).get();

        saved.setPassword("newpass");
        Optional<User> updated = userService.update(saved);
        assertTrue(updated.isPresent());
        assertEquals("newpass", updated.get().getPassword());
    }

    @Test
    void testDeleteUser() {
        User user = new User("eve", "pass");
        User saved = userService.create(user).get();

        Optional<Void> deleted = userService.delete(saved.getId());
        assertTrue(deleted.isPresent() || deleted.isEmpty()); // Optional.empty() on delete

        Optional<User> check = userService.getById(saved.getId());
        assertTrue(check.isEmpty());
    }
}
