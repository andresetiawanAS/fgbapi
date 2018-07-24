package com.api.fgbapi.service;

import com.api.fgbapi.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account save(Account user);
    List<Account> findAll();
    void delete(long id);
    Optional<Account> findById(String user);
    Optional<Account> findByEmail(String email);
    Account updateById(String user);
}
