package com.api.fgbapi.service;

import com.api.fgbapi.repository.BalanceRepository;
import com.api.fgbapi.model.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "balanceService")
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    BalanceRepository balanceRepository;

    @Override
    public Balance save(Balance user) {
        return balanceRepository.save(user);
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
