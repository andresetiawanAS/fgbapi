package com.api.fgbapi.repository;

import com.api.fgbapi.model.TopUpHistory;
import com.api.fgbapi.model.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, String> {
    Optional<TransactionHistory> findById(String user);
}
