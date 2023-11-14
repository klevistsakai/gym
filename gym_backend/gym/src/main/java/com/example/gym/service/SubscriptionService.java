package com.example.gym.service;

import com.example.gym.models.SubscriptionEntity;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {
    // save operation
    SubscriptionEntity saveSubscription(SubscriptionEntity subscription);

    // read operation
    List<SubscriptionEntity> fetchSubscriptionList();

    Optional<SubscriptionEntity> fetchSubscriptionId(Long subscriptionId);

    // update operation
    SubscriptionEntity updateSubscription(SubscriptionEntity subscription, Long subscriptionId);

    // delete operation
    void deleteSubscriptionById(Long subscriptionId);


}
