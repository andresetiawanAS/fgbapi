package com.api.fgbapi.repository;

import com.api.fgbapi.model.TopUpHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopUpHistoryRepository extends JpaRepository<TopUpHistory, String> {
    Optional<TopUpHistory> findById(String user);
}
