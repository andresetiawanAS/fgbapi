package com.api.fgbapi.service;

import com.api.fgbapi.model.TopUpHistory;

import java.util.List;
import java.util.Optional;

public interface TopUpHistoryService {
    TopUpHistory save(TopUpHistory user);
    List<TopUpHistory> findAll();
    void delete(long id);
    Optional<TopUpHistory> findById(String user);
    TopUpHistory updateById(String user);
}
