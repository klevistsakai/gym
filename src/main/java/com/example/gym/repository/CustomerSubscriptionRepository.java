package com.example.gym.repository;

import com.example.gym.models.CustomerSubscriptionEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerSubscriptionRepository extends CrudRepository<CustomerSubscriptionEntity, Long> {
}
