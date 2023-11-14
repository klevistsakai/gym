package com.example.gym.service;

import com.example.gym.models.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    // save operation
    CustomerEntity saveCustomer(CustomerEntity Customer);

    // read operation
    List<CustomerEntity> fetchCustomerList();

    Optional<CustomerEntity> fetchCustomerId(Long customerId);

    // update operation
    CustomerEntity updateCustomer(CustomerEntity Customer, Long CustomerId);

    // delete operation
    void deleteCustomerById(Long CustomerId);
}
