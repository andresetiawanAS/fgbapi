package com.api.fgbapi.repository;

import com.api.fgbapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {

    Account findByEmail(String email);

    Optional<Account> findById(String id);



}
