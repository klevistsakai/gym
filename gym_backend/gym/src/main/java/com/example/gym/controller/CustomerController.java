package com.example.gym.controller;

import java.util.List;
import java.util.Optional;

import com.example.gym.models.CustomerEntity;
import com.example.gym.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

// Annotation
@RestController
@CrossOrigin(origins = "http://localhost:3000")

// Class
@RequestMapping("/api")
public class CustomerController {

    // Annotation
    @Autowired private CustomerService customerService;

    // Save operation
    @PostMapping("/customers/save")
    public CustomerEntity saveCustomer(
            @Valid @RequestBody CustomerEntity customer, @RequestParam("subscriptionId") Long subscriptionId)
    {
       return   customerService.saveCustomerWithSubscription(customer,subscriptionId);


    }

    // Read operation
    @GetMapping("/customers")
    public List<CustomerEntity> fetchCustomerList()
    {

        return customerService.fetchCustomerList();
    }
    @GetMapping("/customers/{id}")
    public Optional<CustomerEntity> fetchCustomerId(@PathVariable("id") Long customerId)
    {

        return customerService.fetchCustomerId(customerId);
    }

    // Update operation
    @PostMapping("/customers/update/{id}")
    public CustomerEntity
    updateCustomer(@RequestBody CustomerEntity customer,
                   @PathVariable("id") Long customerId, @RequestParam("subscriptionId") Long subscriptionId)
    {

        return customerService.updateCustomerWithSubscription(
                customer, customerId,subscriptionId);
    }

    // Delete operation
    @DeleteMapping("/customers/{id}")
    public String deleteCustomerById(@PathVariable("id")
                                             Long customerId)
    {

        customerService.deleteCustomerById(
                customerId);
        return "Deleted Successfully "+customerId;
    }
}