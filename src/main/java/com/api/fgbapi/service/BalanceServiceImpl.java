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
    BalanceRepository balanceRepository; //inject properties yang ada di table balance buat dipake di service

    @Override
    public Balance save(Balance user) {
        return balanceRepository.save(user);
    }

    @Override
    public List<Balance> findAll() {
        return balanceRepository.findAll();
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Optional<Balance> findById(String id) {
        return balanceRepository.findById(id);
    }

    @Override
    public Balance updateById(String user,Double trans) {
        Balance update= balanceRepository.getOne(user);
        Double transValue = trans;
        Double curBalance = update.getBalance();
        Double newBalance = curBalance - transValue;
        update.setBalance(newBalance);
        return balanceRepository.save(update);
    }

    @Override
    public Balance updateBalanceById(String id, Double topUpValue){
        Balance update = balanceRepository.getOne(id);
        update.setBalance(update.getBalance()+topUpValue);
        return balanceRepository.save(update);
    }
}
