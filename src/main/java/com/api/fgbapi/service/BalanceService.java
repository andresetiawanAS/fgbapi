package com.api.fgbapi.service;

import com.api.fgbapi.model.Balance;

import java.util.List;
import java.util.Optional;

public interface BalanceService {
    Balance save(Balance user);
    List<Balance> findAll();
    void delete(long id);
    Optional<Balance> findById(String user);
    Balance updateById(String user);
}
