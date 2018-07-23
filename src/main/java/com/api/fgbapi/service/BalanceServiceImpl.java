package com.api.fgbapi.service;

import com.api.fgbapi.repository.BalanceRepository;
import com.api.fgbapi.model.Balance;

import java.util.List;
import java.util.Optional;

public class BalanceServiceImpl implements BalanceService {

    BalanceRepository balanceRepository;

    @Override
    public Balance save(Balance user) {
        return null;
    }

    @Override
    public List<Balance> findAll() {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Optional<Balance> findById(String user) {
        return Optional.empty();
    }

    @Override
    public Balance updateById(String user) {
        return null;
    }
}
