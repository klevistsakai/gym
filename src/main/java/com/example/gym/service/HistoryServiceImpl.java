package com.example.gym.service;
import com.example.gym.models.HistoryEntity;
import com.example.gym.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class HistoryServiceImpl implements HistoryService{

    @Autowired
    private HistoryRepository historyRepository;

    // save operation
    @Override
    public HistoryEntity saveHistory(HistoryEntity history) {
        return historyRepository.save(history);
    }

    // read operation
    @Override
    public List<HistoryEntity> fetchHistoryList() {
        return (List<HistoryEntity>) historyRepository.findAll();
    }

    @Override
    public Optional<HistoryEntity> fetchHistoryId(Long historyId) {
        return historyRepository.findById(historyId);
    }

    // update operation
    @Override
    public HistoryEntity updateHistory(HistoryEntity history, Long historyId) {
//        HistoryEntity depDB = historyRepository.findById(historyId).get();
//
//        if(Objects.nonNull(history.getDate()) && !"".equalsIgnoreCase(history.getDate().toString()) )
//        {
//            depDB.setDate(history.getDate());
//        }
//
//
//        return historyRepository.save(depDB);
        // would rather not be able to change history
        return history;
    }

    // delete operation
    @Override
    public void deleteHistoryById(Long historyId) {
        historyRepository.deleteById(historyId);
    }

}