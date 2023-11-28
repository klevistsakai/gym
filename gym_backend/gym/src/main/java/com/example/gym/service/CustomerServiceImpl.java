package com.example.gym.service;

import com.example.gym.models.CustomerEntity;
import com.example.gym.models.CustomerSubscriptionEntity;
import com.example.gym.models.SubscriptionEntity;
import com.example.gym.repository.CustomerRepository;
import com.example.gym.repository.CustomerSubscriptionRepository;
import com.example.gym.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerSubscriptionRepository customerSubscriptionRepository;
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    // save operation
    @Override
    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public CustomerEntity saveCustomerWithSubscription(CustomerEntity customer, Long subscriptionId) {
        CustomerEntity model = customerRepository.save(customer);

        SubscriptionEntity subscriptionEntity = subscriptionRepository.findById(subscriptionId).get();


        CustomerSubscriptionEntity subscriptionCustomer = new CustomerSubscriptionEntity();


        subscriptionCustomer.setSubscriptionId(subscriptionId.intValue());

        subscriptionCustomer.setCustomerId(model.getId());

        LocalDate futureDate = LocalDate.now().plusMonths(subscriptionEntity.getDuration());

        java.util.Date date = java.sql.Date.valueOf(futureDate);
        java.sql.Date sqlEndDate = new java.sql.Date(date.getTime());

        subscriptionCustomer.setStartDate(new java.sql.Date((new Date()).getTime()));
        subscriptionCustomer.setEndDate(sqlEndDate);
//        System.out.println(subscriptionCustomer.getSubscriptionId() + "" + subscriptionCustomer.getCustomerId() + subscriptionCustomer.getEndDate() + subscriptionCustomer.getStartDate());
        customerSubscriptionRepository.save(subscriptionCustomer);
        return model;
    }


    // read operation
    @Override
    public List<CustomerEntity> fetchCustomerList() {
        return
                (List<CustomerEntity>) customerRepository.findAll();
    }

    public Optional<CustomerEntity> fetchCustomerId(Long customerId) {
        return customerRepository.findById(customerId);
    }

    // update operation
    @Override
    public CustomerEntity updateCustomer(CustomerEntity customer, Long customerId) {
        CustomerEntity depDB = customerRepository.findById(customerId).get();

        if (Objects.nonNull(customer.getFirstname()) && !"".equalsIgnoreCase(customer.getFirstname())) {
            depDB.setFirstname(customer.getFirstname());

        }
        if (Objects.nonNull(customer.getLastname()) && !"".equalsIgnoreCase(customer.getLastname())) {
            depDB.setLastname(customer.getLastname());
        }
        if (Objects.nonNull(customer.getBirthdate()) && !"".equalsIgnoreCase(customer.getBirthdate().toString())) {
            depDB.setBirthdate(customer.getBirthdate());
        }
        if (Objects.nonNull(customer.getGenderId()) && customer.getGenderId() > 0) {
            depDB.setGenderId(customer.getGenderId());
        }

        return customerRepository.save(depDB);
    }


    @Override
    public CustomerEntity updateCustomerWithSubscription(CustomerEntity customer, Long customerId, Long subscriptionId) {


        CustomerEntity model = this.updateCustomer(customer, customerId);
        SubscriptionEntity subscriptionEntity = subscriptionRepository.findById(subscriptionId).get();

        CustomerSubscriptionEntity subscriptionCustomer = null;

        try {
            subscriptionCustomer = customerSubscriptionRepository.findById(customerId).get();

        } catch (Exception e) {
            subscriptionCustomer = new CustomerSubscriptionEntity();
            subscriptionCustomer.setCustomerId(model.getId());
        }

        subscriptionCustomer.setSubscriptionId(subscriptionId.intValue());

        LocalDate startDateConverted = subscriptionCustomer.getStartDate().toLocalDate().plusMonths(subscriptionEntity.getDuration());
        java.util.Date date = java.sql.Date.valueOf(startDateConverted);
        java.sql.Date sqlEndDate = new java.sql.Date(date.getTime());
        subscriptionCustomer.setEndDate(sqlEndDate);
//        System.out.println(subscriptionCustomer.getSubscriptionId() + "" + subscriptionCustomer.getCustomerId() + subscriptionCustomer.getEndDate() + subscriptionCustomer.getStartDate());
        customerSubscriptionRepository.save(subscriptionCustomer);
        return model;

    }

    // delete operation
    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

}