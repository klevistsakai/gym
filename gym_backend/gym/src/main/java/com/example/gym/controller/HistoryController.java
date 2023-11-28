package com.example.gym.controller;

import com.example.gym.models.HistoryEntity;
import com.example.gym.service.HistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotation
@RestController
@CrossOrigin(origins = "http://localhost:3000")

// Class
@RequestMapping("/api")

public class HistoryController {

    // Annotation
    @Autowired
    private HistoryService historyService;

    // Save operation
    @PostMapping("/histories/save")
    public HistoryEntity saveHistory(
            @Valid @RequestBody HistoryEntity history) {
        return historyService.saveHistory(history);
    }

    // Read operation
    @GetMapping("/histories")
    public List<HistoryEntity> fetchHistoryList() {

        return historyService.fetchHistoryList();
    }

    @GetMapping("/histories/{id}")
    public Optional<HistoryEntity> fetchHistoryId(@PathVariable("id") Long historyId) {

        return historyService.fetchHistoryId(historyId);
    }

    @GetMapping("/histories/customer/{id}")
    public List<HistoryEntity> fetchHistoryByCustomerId(@PathVariable("id") Long historyId) {

        return historyService.fetchHistoryByCustomerId(historyId);
    }
    // Update operation
    @PutMapping("/histories/update/{id}")
    public HistoryEntity
    updateHistory(@RequestBody HistoryEntity history,
                  @PathVariable("id") Long historyId) {

        return historyService.updateHistory(
                history, historyId);
    }

    // Delete operation
    @DeleteMapping("/histories/delete/{id}")
    public String deleteHistoryById(@PathVariable("id")
                                    Long historyId) {

        historyService.deleteHistoryById(
                historyId);
        return "Deleted Successfully";
    }
}