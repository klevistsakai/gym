package com.example.gym.repository;

import com.example.gym.models.GenderEntity;
import org.springframework.data.repository.CrudRepository;

public interface GenderRepository extends CrudRepository<GenderEntity, Long> {
}
