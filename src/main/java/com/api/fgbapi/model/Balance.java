package com.api.fgbapi.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "balance")
@EntityListeners(AuditingEntityListener.class)
public class Balance {
    @Id
    String id;
    String id_card;
    Double balance;
    Date last_topup;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getLast_topup() {
        return last_topup;
    }

    public void setLast_topup(Date last_topup) {
        this.last_topup = last_topup;
    }
}
