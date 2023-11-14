package com.example.gym.service;

import com.example.gym.models.CustomerEntity;
import com.example.gym.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    // save operation
    @Override
    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    // read operation
    @Override
    public List<CustomerEntity> fetchCustomerList() {
        return (List<CustomerEntity>) customerRepository.findAll();
    }

    public Optional<CustomerEntity> fetchCustomerId(Long customerId){
        return  customerRepository.findById(customerId);
    }

    // update operation
    @Override
    public CustomerEntity updateCustomer(CustomerEntity customer, Long customerId) {
        CustomerEntity depDB = customerRepository.findById(customerId).get();

        if(Objects.nonNull(customer.getFirstname()) && !"".equalsIgnoreCase(customer.getFirstname()) )
        {
            depDB.setFirstname(customer.getFirstname());

        }
        if(Objects.nonNull(customer.getLastname()) && !"".equalsIgnoreCase(customer.getLastname()) )
        {
            depDB.setLastname(customer.getLastname());
        }
        if(Objects.nonNull(customer.getBirthdate()) && !"".equalsIgnoreCase(customer.getBirthdate().toString()) )
        {
            depDB.setBirthdate(customer.getBirthdate());
        }
        if(Objects.nonNull(customer.getGenderId()) && customer.getGenderId()>0 )
        {
            depDB.setGenderId(customer.getGenderId());
        }

        return customerRepository.save(depDB);
    }

    // delete operation
    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

}