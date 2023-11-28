package com.example.gym.controller;


import com.example.gym.models.GenderEntity;
import com.example.gym.repository.GenderRepository;
import com.example.gym.service.GenderService;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GenderController.class)
public class GenderControllerTest {

    @MockBean
    @Autowired
    private GenderService Service;
    @MockBean
    @Autowired
    private GenderRepository repository;
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllGendersAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/api/genders")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void getGenderByIdAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/api/genders/{id}",1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void createGenderAPI() throws Exception
    {
        GenderEntity gender = new GenderEntity();
        gender.setName("ee");
        gender.setId(4);
        mvc.perform( MockMvcRequestBuilders
                        .post("/api/genders/save")
                        .content(asJsonString(gender))
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
    public void updateGenderAPI() throws Exception
    {
        GenderEntity gender = new GenderEntity();
        gender.setName("ee3");
        gender.setId(4);
        mvc.perform( MockMvcRequestBuilders
                        .put("/api/genders/update/{id}", 4)
                        .content(asJsonString(gender))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    public void deleteGenderAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders.delete("/api/genders/delete/{id}", 4) )
                .andExpect(status().isOk())                .andDo(print());

    }
}
