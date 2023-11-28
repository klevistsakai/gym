package com.example.gym.controller;

import com.example.gym.GymApplication;
import com.example.gym.controller.UserController;
import com.example.gym.models.GenderEntity;
import com.example.gym.models.UserEntity;
import com.example.gym.service.UserService;
import com.example.gym.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.*;


import org.springframework.http.MediaType;

@ContextConfiguration(classes= GymApplication.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    @Autowired
    private UserService userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldCreateUser() throws Exception {
        UserEntity user = new UserEntity();
        user.setId(666);
        user.setUsername("Demon");
        user.setPasswordHash("beepboop");
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        user.setPasswordHash(bc.encode(user.getPasswordHash()));
        GenderEntity gender=  new GenderEntity();
        gender.setId(1);
        gender.setName("male");
        user.setGender(gender);
        user.setFirstname("De");
        user.setLastname("mon");
        user.setGenderId(1);
        user.setValidated((byte) 0);

        Mockito.when(userRepository.saveUser(ArgumentMatchers.any())).thenReturn(user);

        mockMvc.perform(post("/api/users/save").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(asJsonString(user)).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(666)))
                .andExpect(jsonPath("$.username", Matchers.equalTo("Demon")))
                .andExpect(jsonPath("$.firstname", Matchers.equalTo("De")))
                .andExpect(jsonPath("$.lastname", Matchers.equalTo("mon")))
                .andExpect(jsonPath("$.genderId", Matchers.equalTo(1)))
                .andDo(print());
//        Mockito.verify(userRepository).saveUser(Mockito.any(user.class));
        Mockito.verify(userRepository, times(0)).shouldCreateUser(any(UserEntity.class));




    }

    @Test
    public void shouldReturnUser() throws Exception {
        long id = 666l;
        UserEntity user = new UserEntity();
        user.setId(666);
        user.setUsername("Demon");
        user.setPasswordHash("beepboop");
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        user.setPasswordHash(bc.encode(user.getPasswordHash()));
        GenderEntity gender=  new GenderEntity();
        gender.setId(1);
        gender.setName("male");
        user.setFirstname("De");
        user.setLastname("mon");
        user.setGenderId(1);
        System.out.println(user);

        when(userRepository.fetchUserId(id)).thenReturn(Optional.of(user));
        mockMvc.perform(get("/api/users/{id}", id)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.username").value(user.getUsername()))
                .andExpect(jsonPath("$.passwordHash").value(user.getPasswordHash()))
                .andExpect(jsonPath("$.firstname").value(user.getFirstname()))
                .andExpect(jsonPath("$.lastname").value(user.getLastname()))
                .andExpect(jsonPath("$.genderId").value(user.getGenderId()))

                .andDo(print());
    }



    @Test
    public void shouldReturnListOfUsers() throws Exception {
        UserEntity user = new UserEntity();
        user.setId(6616);
        user.setUsername("Demo2n");
        user.setPasswordHash("beepboop");
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        user.setPasswordHash(bc.encode(user.getPasswordHash()));
        GenderEntity gender=  new GenderEntity();
        gender.setId(1);
        gender.setName("male");
        user.setFirstname("De");
        user.setLastname("mon");
        user.setGenderId(1);
        UserEntity user1 = new UserEntity();
        user1.setId(6667);
        user1.setUsername("Dem1on");
        user1.setPasswordHash("beepboop");

        user1.setPasswordHash(bc.encode(user1.getPasswordHash()));
        user1.setFirstname("De");
        user1.setLastname("mon");
        user1.setGenderId(1);
        UserEntity user2 = new UserEntity();
        user2.setId(333);
        user2.setUsername("Demon");
        user2.setPasswordHash("beepboop");
        user2.setPasswordHash(bc.encode(user2.getPasswordHash()));
        user2.setFirstname("De");
        user2.setLastname("mon");
        user2.setGenderId(1);
        List<UserEntity> users = new ArrayList<>(
                Arrays.asList(user,user1,user2));

        when(userRepository.fetchUserList()).thenReturn(users);
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(users.size()))
                .andDo(print());
    }

    @Test
    public void shouldUpdateUser() throws Exception {
        long id = 6667l;

        UserEntity user = new UserEntity();
        user.setId(6616);
        user.setUsername("Demo2n");
        user.setPasswordHash("beepboop");
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        user.setPasswordHash(bc.encode(user.getPasswordHash()));
        GenderEntity gender=  new GenderEntity();
        gender.setId(1);
        gender.setName("male");
        user.setGender(gender);
        user.setFirstname("De");
        user.setLastname("mon");
        user.setGenderId(1);
        UserEntity user1 = new UserEntity();
        user1.setId(6667);
        user1.setUsername("Dem1on");
        user1.setPasswordHash("beepboop");
        user1.setGender(gender);
        user1.setPasswordHash(bc.encode(user1.getPasswordHash()));
        user1.setFirstname("De2");
        user1.setLastname("mon2");
        user1.setGenderId(1);

        when(userRepository.fetchUserId(id)).thenReturn(Optional.of(user));
        when(userRepository.saveUser(any(UserEntity.class))).thenReturn(user1);

        mockMvc.perform(put("/api/users/update/{id}", id).contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(user1)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void shouldDeleteUser() throws Exception {
        long id = 666L;

        doNothing().when(userRepository).deleteUserById(id);
        mockMvc.perform(delete("/api/users/delete/{id}", id))
                .andExpect(status().isOk())
                .andDo(print());
    }

    // Dont do that homie!!!
//    @Test
//    void shouldDeleteAllUsers() throws Exception {
//        doNothing().when(userRepository).deleteAll();
//        mockMvc.perform(delete("/api/users"))
//                .andExpect(status().isNoContent())
//                .andDo(print());
//    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

