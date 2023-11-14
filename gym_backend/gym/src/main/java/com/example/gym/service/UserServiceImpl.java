package com.example.gym.service;


import com.example.gym.models.UserEntity;
import com.example.gym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return userRepository.save(user);
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
        UserEntity depDB = userRepository.findById(userId).get();
        if(Objects.nonNull(user.getUsername()) && !"".equalsIgnoreCase(user.getUsername()) )
        {
            depDB.setUsername(user.getUsername());
        }
        if(Objects.nonNull(user.getFirstname()) && !"".equalsIgnoreCase(user.getFirstname()) )
        {
            depDB.setFirstname(user.getFirstname());
        }
        if(Objects.nonNull(user.getLastname()) && !"".equalsIgnoreCase(user.getLastname()) )
        {
            depDB.setLastname(user.getFirstname());
        }
        if(Objects.nonNull(user.getLastname()) && !"".equalsIgnoreCase(user.getLastname()) )
        {
            depDB.setLastname(user.getFirstname());
        }
        if(Objects.nonNull(user.getGenderId()) && user.getGenderId()>0 )
        {
            depDB.setGenderId(user.getGenderId());
        }
    // we dont care about validated anything other 0 works.
        return userRepository.save(depDB);
    }

    // delete operation
    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

}