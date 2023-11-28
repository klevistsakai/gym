package com.example.gym.service;

import com.example.gym.models.HistoryEntity;

import java.util.List;
import java.util.Optional;

public interface HistoryService {
    // save operation
    HistoryEntity saveHistory(HistoryEntity history);

    // read operation
    List<HistoryEntity> fetchHistoryList();

    Optional<HistoryEntity> fetchHistoryId(Long historyId);

    // update operation
    HistoryEntity updateHistory(HistoryEntity history, Long historyId);

    // delete operation
    void deleteHistoryById(Long historyId);


    List<HistoryEntity> fetchHistoryByCustomerId(Long historyId);
}
