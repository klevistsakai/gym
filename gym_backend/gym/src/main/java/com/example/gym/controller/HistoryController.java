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

// Class
public class HistoryController {

    // Annotation
    @Autowired private HistoryService historyService;

    // Save operation
    @PostMapping("/historys/save")
    public HistoryEntity saveHistory(
            @Valid @RequestBody HistoryEntity history)
    {

        return historyService.saveHistory(history);
    }

    // Read operation
    @GetMapping("/historys")
    public List<HistoryEntity> fetchHistoryList()
    {

        return historyService.fetchHistoryList();
    }
    @GetMapping("/historys/{id}")
    public Optional<HistoryEntity> fetchHistoryId(@PathVariable("id") Long historyId)
    {

        return historyService.fetchHistoryId(historyId);
    }

    // Update operation
    @PutMapping("/historys/update/{id}")
    public HistoryEntity
    updateHistory(@RequestBody HistoryEntity history,
                  @PathVariable("id") Long historyId)
    {

        return historyService.updateHistory(
                history, historyId);
    }

    // Delete operation
    @DeleteMapping("/historys/delete/{id}")
    public String deleteHistoryById(@PathVariable("id")
                                            Long historyId)
    {

        historyService.deleteHistoryById(
                historyId);
        return "Deleted Successfully";
    }
}