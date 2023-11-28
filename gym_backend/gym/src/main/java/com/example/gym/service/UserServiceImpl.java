package com.example.gym.service;


import com.example.gym.models.UserEntity;
import com.example.gym.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // save operation
    @Override
    public UserEntity saveUser(UserEntity user) {

        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        user.setPasswordHash(bc.encode(user.getPasswordHash()));
        return userRepository.save(user);
    }


    public UserEntity getUserByUsernamePassword(String username, String password) {
        List<UserEntity> list= userRepository.findByUsername(username);
        if(list.size()>0) {
            UserEntity user = list.get(0);


            BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
            if (bc.matches(password, user.getPasswordHash()))
                return user;
        }
        return null;

    }

    @Override
    public void shouldCreateUser(UserEntity any) {
        userRepository.save(any);
    }

    // read operation
    @Override
    public List<UserEntity> fetchUserList() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> fetchUserId(Long userId) {
        return userRepository.findById(userId);
    }

    // update operation
    @Override
    public UserEntity updateUser(UserEntity user, Long userId) {
        UserEntity userDB = userRepository.findById(userId).get();
        if (Objects.nonNull(user.getUsername()) && !"".equalsIgnoreCase(user.getUsername())) {
            userDB.setUsername(user.getUsername());
        }
        if (Objects.nonNull(user.getPasswordHash()) && !"".equalsIgnoreCase(user.getPasswordHash())) {
            BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
//            user.setPasswordHash(bc.encode(user.getPasswordHash()));

            userDB.setPasswordHash(bc.encode(user.getPasswordHash()));
        }
        if (Objects.nonNull(user.getFirstname()) && !"".equalsIgnoreCase(user.getFirstname())) {
            userDB.setFirstname(user.getFirstname());
        }
        if (Objects.nonNull(user.getLastname()) && !"".equalsIgnoreCase(user.getLastname())) {
            userDB.setLastname(user.getLastname());
        }
        if (Objects.nonNull(user.getGenderId()) && user.getGenderId() > 0) {
            userDB.setGenderId(user.getGenderId());
        }
        // we dont care about validated anything other 0 works.
        return userRepository.save(userDB);
    }

    // delete operation
    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

}