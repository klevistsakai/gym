package com.example.gym.service;

import com.example.gym.models.CustomerSubscriptionEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerSubscriptionService {
    // save operation
    CustomerSubscriptionEntity saveCustomerSubscription(CustomerSubscriptionEntity CustomerSubscription);

    // read operation
    List<CustomerSubscriptionEntity> fetchCustomerSubscriptionList();

    Optional<CustomerSubscriptionEntity> fetchCustomerSubscriptionId(Long customerId);
    // update operation
    CustomerSubscriptionEntity updateCustomerSubscription(CustomerSubscriptionEntity CustomerSubscription, Long CustomerSubscriptionId);

    // delete operation
    void deleteCustomerSubscriptionById(Long CustomerSubscriptionId);


}
