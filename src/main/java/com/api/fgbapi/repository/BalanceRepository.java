package com.api.fgbapi.repository;

import com.api.fgbapi.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface BalanceRepository extends JpaRepository<Balance, String> {

    Optional<Balance> findById(String id);
    //Balance updateById(String id);
}
