package com.example.gym.repository;

import com.example.gym.models.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<UserEntity, Long> {
}
