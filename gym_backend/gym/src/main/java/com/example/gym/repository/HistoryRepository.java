package com.example.gym.repository;

import com.example.gym.models.HistoryEntity;
import com.example.gym.models.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistoryRepository extends CrudRepository<HistoryEntity, Long> {
    @Query("from HistoryEntity where customerId =:Id")
    public List<HistoryEntity> findByCustomerId(Long Id);
}
