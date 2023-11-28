package com.example.gym.repository;

import com.example.gym.models.CustomerSubscriptionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import jakarta.persistence.*;

public interface CustomerSubscriptionRepository extends CrudRepository<CustomerSubscriptionEntity, Long> {
    @Query("from CustomerSubscriptionEntity where subscriptionId = :subscriptionId and customerId=:customerId")
    Optional<CustomerSubscriptionEntity> findByIds(Long subscriptionId,Long customerId );
}
