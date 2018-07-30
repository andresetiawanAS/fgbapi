package com.api.fgbapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.internal.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "balance")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"last_topup"}, allowGetters = true)
public class Balance implements Serializable {
    @Id 
    String id;
    String id_card;
    Double balance;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date last_topup = new Date();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "acc_id")
    @JsonBackReference
    private Account account;
    
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
