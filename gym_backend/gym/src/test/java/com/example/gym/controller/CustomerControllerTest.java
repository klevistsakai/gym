package com.example.gym.controller;


import com.example.gym.models.CustomerEntity;
import com.example.gym.models.CustomerSubscriptionEntity;
import com.example.gym.models.GenderEntity;
import com.example.gym.repository.CustomerRepository;
import com.example.gym.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Date;
import java.sql.Timestamp;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @MockBean
    @Autowired
    private CustomerService Service;
    @MockBean
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllCustomersAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/api/customers")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void getCustomerByIdAPI() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/customers/{id}",1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void createCustomerAPI() throws Exception
    {
        CustomerEntity customer = new CustomerEntity();
        customer.setId(666);
        customer.setGenderId(1);
        customer.setBirthdate(new java.sql.Date((new java.util.Date()).getTime()));
        customer.setLastname("eee");
        customer.setFirstname("eeee");
        GenderEntity gender = new GenderEntity();
        gender.setId(1);
        gender.setName("male");
        customer.setGender(gender);
        CustomerSubscriptionEntity CS = new CustomerSubscriptionEntity();
        CS.setCustomerId(666);
        CS.setSubscriptionId(3);
        CS.setStartDate(new java.sql.Date((new java.util.Date()).getTime()));
        CS.setEndDate(new java.sql.Date((new java.util.Date()).getMonth()));
        customer.setCustomerSubscription(CS);
        mvc.perform( MockMvcRequestBuilders
                        .post("/api/customers/save").param("subscriptionId", "1")
                        .content(asJsonString(customer))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(customer);

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void updateCustomerAPI() throws Exception
    {
        CustomerEntity customer = new CustomerEntity();
        customer.setId(666);
        customer.setGenderId(1);
        customer.setBirthdate(new java.sql.Date((new java.util.Date()).getTime()));
        customer.setLastname("eee");
        customer.setFirstname("eeee");
        GenderEntity gender = new GenderEntity();
        gender.setId(1);
        gender.setName("male");
        customer.setGender(gender);
        CustomerSubscriptionEntity CS = new CustomerSubscriptionEntity();
        CS.setCustomerId(666);
        CS.setSubscriptionId(3);
        CS.setStartDate(new java.sql.Date((new java.util.Date()).getTime()));
        CS.setEndDate(new java.sql.Date((new java.util.Date()).getMonth()));
        customer.setCustomerSubscription(CS);
        mvc.perform( MockMvcRequestBuilders
                        .post("/api/customers/update/{id}", 1).param("subscriptionId", "1")
                        .content(asJsonString(customer))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    public void deleteCustomerAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders.delete("/api/customers/{id}", 4) )
                .andExpect(status().isOk())                .andDo(print());

    }
}
