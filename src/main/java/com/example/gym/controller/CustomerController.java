package com.example.gym.controller;

import java.util.List;
import java.util.Optional;

import com.example.gym.models.CustomerEntity;
import com.example.gym.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Annotation
@RestController

// Class
public class CustomerController {

    // Annotation
    @Autowired private CustomerService customerService;

    // Save operation
    @PostMapping("/customers")
    public CustomerEntity saveCustomer(
            @Valid @RequestBody CustomerEntity customer)
    {

        return customerService.saveCustomer(customer);
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
    @PutMapping("/customers/update/{id}")
    public CustomerEntity
    updateCustomer(@RequestBody CustomerEntity customer,
                   @PathVariable("id") Long customerId)
    {

        return customerService.updateCustomer(
                customer, customerId);
    }

    // Delete operation
    @DeleteMapping("/customers/{id}")
    public String deleteCustomerById(@PathVariable("id")
                                             Long customerId)
    {

        customerService.deleteCustomerById(
                customerId);
        return "Deleted Successfully";
    }
}