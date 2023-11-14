package com.example.gym.repository;

import com.example.gym.models.HistoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<HistoryEntity, Long> {
}
