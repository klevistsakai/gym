package com.example.gym.controller;

import com.example.gym.models.CustomerSubscriptionEntity;
import com.example.gym.service.CustomerSubscriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotation
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")

// Class
public class CustomerSubscriptionController {

    // Annotation
    @Autowired private CustomerSubscriptionService customerSubscriptionService;

    // Save operation
    @PostMapping("/customerSubscriptions/save")
    public CustomerSubscriptionEntity saveCustomerSubscription(
            @Valid @RequestBody CustomerSubscriptionEntity customerSubscription)
    {

        return customerSubscriptionService.saveCustomerSubscription(customerSubscription);
    }

    // Read operation
    @GetMapping("/customerSubscriptions")
    public List<CustomerSubscriptionEntity> fetchCustomerSubscriptionList()
    {

        return customerSubscriptionService.fetchCustomerSubscriptionList();
    }
    @GetMapping("/customerSubscriptions/{id}")
    public Optional<CustomerSubscriptionEntity> fetchCustomerSubscriptionEntityId(@PathVariable("id") Long customerId )
    {

        return customerSubscriptionService.fetchCustomerSubscriptionId(customerId);
    }

    // Update operation
    @PutMapping("/customerSubscriptions/update/{id}")
    public CustomerSubscriptionEntity
    updateCustomerSubscription(@RequestBody CustomerSubscriptionEntity customerSubscription,
                               @PathVariable("id") Long customerSubscriptionId)
    {

        return customerSubscriptionService.updateCustomerSubscription(
                customerSubscription, customerSubscriptionId);
    }

    // Delete operation
    @DeleteMapping("/customerSubscriptions/delete/{id}")
    public String deleteCustomerSubscriptionById(@PathVariable("id")
                                                         Long customerSubscriptionId)
    {

        customerSubscriptionService.deleteCustomerSubscriptionById(
                customerSubscriptionId);
        return "Deleted Successfully";
    }
}