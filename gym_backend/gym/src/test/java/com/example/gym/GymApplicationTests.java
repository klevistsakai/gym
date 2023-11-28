package com.example.gym;

import com.example.gym.controller.CustomerControllerTest;
import com.example.gym.controller.GenderControllerTest;
import com.example.gym.controller.HistoryControllerTest;
import com.example.gym.controller.UserControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GymApplicationTests {

    @Test
    void contextLoads() throws Exception {
        GenderControllerTest g = new GenderControllerTest();
        HistoryControllerTest h = new HistoryControllerTest();
        CustomerControllerTest c = new CustomerControllerTest();
        UserControllerTest u = new UserControllerTest();
//        g.createGenderAPI();
//        g.getGenderByIdAPI();
//        g.updateGenderAPI();
//        g.getAllGendersAPI();
//        g.deleteGenderAPI();
//        h.createHistoryAPI();
//        h.getAllHistorysAPI();
//        h.getHistoryByIdAPI();
//        h.updateHistoryAPI();
//        h.deleteHistoryAPI();
//        c.createCustomerAPI();
//        c.getAllCustomersAPI();
//        c.getCustomerByIdAPI();
//        c.updateCustomerAPI();
//        c.deleteCustomerAPI();
//        u.shouldCreateUser();
//        u.shouldUpdateUser();
//        u.shouldReturnUser();
//        u.shouldReturnListOfUsers();
//        u.shouldDeleteUser();
//
//



    }

}
