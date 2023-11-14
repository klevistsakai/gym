package com.example.gym.service;

import com.example.gym.models.CustomerSubscriptionEntity;
import com.example.gym.repository.CustomerSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerSubscriptionServiceImpl implements CustomerSubscriptionService{

    @Autowired
    private CustomerSubscriptionRepository customerSubscriptionRepository;

    // save operation
    @Override
    public CustomerSubscriptionEntity saveCustomerSubscription(CustomerSubscriptionEntity customerSubscription) {
        return customerSubscriptionRepository.save(customerSubscription);
    }

    // read operation
    @Override
    public List<CustomerSubscriptionEntity> fetchCustomerSubscriptionList() {
        return (List<CustomerSubscriptionEntity>) customerSubscriptionRepository.findAll();
    }

    @Override
    public Optional<CustomerSubscriptionEntity> fetchCustomerSubscriptionId(Long customerId) {
        return customerSubscriptionRepository.findById(customerId);
    }

    // update operation
    @Override
    public CustomerSubscriptionEntity updateCustomerSubscription(CustomerSubscriptionEntity customerSubscription, Long customerSubscriptionId) {
        CustomerSubscriptionEntity depDB = customerSubscriptionRepository.findById(customerSubscriptionId).get();

        if(Objects.nonNull(customerSubscription.getStartDate()) && !"".equalsIgnoreCase(customerSubscription.getStartDate().toString()) )
        {
            depDB.setStartDate(customerSubscription.getStartDate());
        }
        if(Objects.nonNull(customerSubscription.getEndDate()) && !"".equalsIgnoreCase(customerSubscription.getEndDate().toString()) )
        {
            depDB.setEndDate(customerSubscription.getEndDate());
        }


        return customerSubscriptionRepository.save(depDB);
    }

    // delete operation
    @Override
    public void deleteCustomerSubscriptionById(Long customerSubscriptionId) {
        customerSubscriptionRepository.deleteById(customerSubscriptionId);
    }

}