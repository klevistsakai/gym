package com.example.gym.controller;

import com.example.gym.models.GenderEntity;
import com.example.gym.service.GenderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

// Annotation
@RestController
@CrossOrigin(origins = "http://localhost:3000")
// Class
@RequestMapping(value = "/api" , produces = APPLICATION_JSON_VALUE)

public class GenderController {

    // Annotation
    @Autowired private GenderService genderService;

    // Save operation
    @PostMapping("/genders/save")
    public GenderEntity saveGender(
            @Valid @RequestBody GenderEntity gender)
    {

        return genderService.saveGender(gender);
    }

    // Read operation
    @GetMapping("/genders")
    public List<GenderEntity> fetchGenderList()
    {

        return genderService.fetchGenderList();
    }
    @GetMapping("/genders/{id}")
    public Optional<GenderEntity> fetchGenderId(@PathVariable("id") Long genderId)
    {

        return genderService.fetchGenderId(genderId);
    }


    // Update operation
    @PutMapping("/genders/update/{id}")
    public GenderEntity
    updateGender(@RequestBody GenderEntity gender,
                 @PathVariable("id") Long genderId)
    {

        return genderService.updateGender(
                gender, genderId);
    }


    // Delete operation
    @DeleteMapping("/genders/delete/{id}")
    public String deleteGenderById(@PathVariable("id")
                                           Long genderId)
    {

        genderService.deleteGenderById(
                genderId);
        return "Deleted Successfully";
    }
}