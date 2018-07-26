package com.api.fgbapi.service;

import com.api.fgbapi.model.TopUpHistory;
import com.api.fgbapi.model.TransactionHistory;
import com.api.fgbapi.repository.TopUpHistoryRepository;
import com.api.fgbapi.repository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service (value= "transactionService")
public class TransactionHistoryServiceImpl implements TransactionHistoryService{

    @Autowired
    TransactionHistoryRepository transactionHistoryRepository;

    @Override
    public List<TransactionHistory> findAll(){
        return transactionHistoryRepository.findAll();
    }

    @Override
    public Optional<TransactionHistory> findById(String user){
        return transactionHistoryRepository.findById(user);
    }

    @Override
    public TransactionHistory save(TransactionHistory user){
        return transactionHistoryRepository.save(user);
    }

    @Override
    public void delete(TransactionHistory transactionHistory){
        transactionHistoryRepository.save(transactionHistory);
    }

    @Override
    public TransactionHistory updateById(String user){
        return null;
    }
}
