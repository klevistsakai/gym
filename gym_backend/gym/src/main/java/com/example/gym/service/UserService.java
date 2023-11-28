package com.example.gym.service;

import com.example.gym.models.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
        // save operation
        UserEntity saveUser(UserEntity user);

    // read operation
    List<UserEntity> fetchUserList();

    Optional<UserEntity> fetchUserId(Long userId);

    // update operation
    UserEntity updateUser(UserEntity user, Long userId);

    // delete operation
    void deleteUserById(Long userId);

    public UserEntity getUserByUsernamePassword(String username,String password);


    void shouldCreateUser(UserEntity any);
}
