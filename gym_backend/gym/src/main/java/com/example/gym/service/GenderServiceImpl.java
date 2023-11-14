package com.example.gym.service;

import com.example.gym.models.GenderEntity;
import com.example.gym.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService{

    @Autowired
    private GenderRepository genderRepository;

    // save operation
    @Override
    public GenderEntity saveGender(GenderEntity gender) {
        return genderRepository.save(gender);
    }

    // read operation
    @Override
    public List<GenderEntity> fetchGenderList() {
        return (List<GenderEntity>) genderRepository.findAll();
    }

    @Override
    public Optional<GenderEntity> fetchGenderId(Long genderId) {
        return genderRepository.findById(genderId);
    }

    // update operation
    @Override
    public GenderEntity updateGender(GenderEntity gender, Long genderId) {
        GenderEntity depDB = genderRepository.findById(genderId).get();

        if(Objects.nonNull(gender.getName()) && !"".equalsIgnoreCase(gender.getName()) )
        {
            depDB.setName(gender.getName());

        }

        return genderRepository.save(depDB);
    }

    // delete operation
    @Override
    public void deleteGenderById(Long genderId) {
        genderRepository.deleteById(genderId);
    }

}