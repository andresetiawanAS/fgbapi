package com.api.fgbapi.service;

import com.api.fgbapi.model.TopUpHistory;
import com.api.fgbapi.model.TransactionHistory;

import java.util.List;
import java.util.Optional;

public interface TransactionHistoryService  {
    TransactionHistory save(TransactionHistory user);
    List<TransactionHistory> findAll();
    void delete(TransactionHistory transactionHistory);
    Optional<TransactionHistory> findById(String user);
    TransactionHistory updateById(String user);
}
