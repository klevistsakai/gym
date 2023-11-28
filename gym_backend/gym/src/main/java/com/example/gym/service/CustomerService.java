package com.example.gym.service;

import com.example.gym.models.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    // save operation
    CustomerEntity saveCustomer(CustomerEntity customer);
    CustomerEntity saveCustomerWithSubscription(CustomerEntity customer,Long subscriptionId);
    // read operation
    List<CustomerEntity> fetchCustomerList();

    Optional<CustomerEntity> fetchCustomerId(Long customerId);

    // update operation
    CustomerEntity updateCustomer(CustomerEntity Customer, Long CustomerId);
     CustomerEntity updateCustomerWithSubscription(CustomerEntity customer, Long customerId,Long subscriptionId);
    // delete operation
    void deleteCustomerById(Long CustomerId);
}
