package com.example.gym.controller;

import com.example.gym.models.UserEntity;
import com.example.gym.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotation
@RestController

// Class
public class UserController {

    // Annotation
    @Autowired private UserService userService;

    // Save operation
    @PostMapping("/users/save")
    public UserEntity saveUser(
            @Valid @RequestBody UserEntity user)
    {

        return userService.saveUser(user);
    }

    // Read operation
    @GetMapping("/users")
    public List<UserEntity> fetchUserList()
    {

        return userService.fetchUserList();
    }

    @GetMapping("/users/{id}")
    public Optional<UserEntity> fetchUserId(@PathVariable("id") Long userId)
    {

        return userService.fetchUserId(userId);
    }

    // Update operation
    @PutMapping("/users/update/{id}")
    public UserEntity
    updateUser(@RequestBody UserEntity user,
               @PathVariable("id") Long userId)
    {

        return userService.updateUser(
                user, userId);
    }

    // Delete operation
    @DeleteMapping("/users/delete/{id}")
    public String deleteUserById(@PathVariable("id")
                                         Long userId)
    {

        userService.deleteUserById(
                userId);
        return "Deleted Successfully";
    }
}