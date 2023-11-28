package com.example.gym.controller;


import com.example.gym.models.CustomerEntity;
import com.example.gym.models.HistoryEntity;
import com.example.gym.repository.HistoryRepository;
import com.example.gym.service.HistoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Timestamp;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HistoryController.class)
public class HistoryControllerTest {

    @MockBean
    @Autowired
    private HistoryService Service;
    @MockBean
    @Autowired
    private HistoryRepository repository;
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllHistorysAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/api/histories")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void getHistoryByIdAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/api/histories/{id}",1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void createHistoryAPI() throws Exception
    {
        HistoryEntity history = new HistoryEntity();
        history.setCustomerId(1);
        history.setId(4);
        history.setDate(new Timestamp(System.currentTimeMillis()));
        history.setCustomer(new CustomerEntity());
        mvc.perform( MockMvcRequestBuilders
                        .post("/api/histories/save")
                        .content(asJsonString(history))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void updateHistoryAPI() throws Exception
    {
        HistoryEntity history = new HistoryEntity();
        history.setCustomerId(1);
        history.setId(4);
        history.setDate(new Timestamp(System.currentTimeMillis()));
        history.setCustomer(new CustomerEntity());
        mvc.perform( MockMvcRequestBuilders
                        .put("/api/histories/update/{id}", 4)
                        .content(asJsonString(history))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    public void deleteHistoryAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders.delete("/api/histories/delete/{id}", 4) )
                .andExpect(status().isOk())                .andDo(print());

    }
}
