package com.example.gym.controller;

import com.example.gym.models.CustomerSubscriptionEntity;
import com.example.gym.models.UserEntity;
import com.example.gym.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotation
@RestController
@CrossOrigin(origins = "http://localhost:3000")

// Class
@RequestMapping("/api")

public class UserController {

    // Annotation
    @Autowired
    private UserService userService;

    // Save operation
//    @PostMapping(value = "/users/save" , consumes = "application/json", produces = "application/json")
    @PostMapping("/users/save")
    public UserEntity saveUser(
            @Valid @RequestBody UserEntity user) {

        return userService.saveUser(user);
    }


    @RequestMapping(value = "/users/login", method = RequestMethod.POST, consumes = "application/json")

    public ResponseEntity<?> userLogin(@Valid @RequestBody UserEntity user) {


        UserEntity userFound = userService.getUserByUsernamePassword(user.getUsername(), user.getPasswordHash());
        if (userFound == null)
            return new ResponseEntity<>(
                    "Wrong username/password",
                    HttpStatus.BAD_REQUEST);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userFound);

    }


    // Read operation
    @GetMapping("/users")
    public List<UserEntity> fetchUserList() {

        return userService.fetchUserList();
    }

    @GetMapping("/users/{id}")
    public Optional<UserEntity> fetchUserId(@PathVariable("id") Long userId) {

        return userService.fetchUserId(userId);
    }

    // Update operation
    @PutMapping("/users/update/{id}")
    public UserEntity
    updateUser(@RequestBody UserEntity user,
               @PathVariable("id") Long userId) {

        return userService.updateUser(
                user, userId);
    }

    // Delete operation
    @DeleteMapping("/users/delete/{id}")
    public String deleteUserById(@PathVariable("id")
                                 Long userId) {

        userService.deleteUserById(
                userId);
        return "Deleted Successfully";
    }
}