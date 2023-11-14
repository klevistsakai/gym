package com.example.gym.service;

import com.example.gym.models.GenderEntity;

import java.util.List;
import java.util.Optional;

public interface GenderService {
    // save operation
    GenderEntity saveGender(GenderEntity gender);

    // read operation
    List<GenderEntity> fetchGenderList();

    Optional<GenderEntity> fetchGenderId(Long genderId);
    // update operation
    GenderEntity updateGender(GenderEntity gender, Long genderId);

    // delete operation
    void deleteGenderById(Long genderId);


}
