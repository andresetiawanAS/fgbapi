package com.api.fgbapi.service;

import com.api.fgbapi.model.TopUpHistory;
import com.api.fgbapi.repository.TopUpHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "historyService")
public class TopUpHistoryServiceImpl implements TopUpHistoryService{

    @Autowired
    TopUpHistoryRepository topUpHistoryRepository;

    @Override
    public List<TopUpHistory> findAll(){
        return topUpHistoryRepository.findAll();
    }

    @Override
    public Optional<TopUpHistory> findById(String user){
        return topUpHistoryRepository.findById(user);
    }

    @Override
    public TopUpHistory save(TopUpHistory user){
        return topUpHistoryRepository.save(user);
    }

    @Override
    public void delete(String id){
        topUpHistoryRepository.delete(id);
    }

    @Override
    public TopUpHistory updateById(String user){
        return null;
    }
}
