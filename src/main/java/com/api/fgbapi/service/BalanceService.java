package com.api.fgbapi.service;

import com.api.fgbapi.model.Balance;

import java.util.List;
import java.util.Optional;

public interface BalanceService {
    Balance save(Balance user);
    List<Balance> findAll();
    void delete(long id);
    Optional<Balance> findById(String id);
    Balance updateById(String id, Double trans);
    Balance updateBalanceById(String id, Double topUpValue);
    Balance updateCardById(Balance user);

}
