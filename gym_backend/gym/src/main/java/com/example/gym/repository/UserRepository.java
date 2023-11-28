package com.example.gym.repository;

import com.example.gym.models.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository  extends CrudRepository<UserEntity, Long> {


    @Query("from UserEntity where username like :username")
    public List<UserEntity> findByUsername(String username);
}
