package com.api.fgbapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction_history")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"transaction_date"},
        allowGetters = true)

public class TransactionHistory {
    @Id
    String id;
    Double transaction_value;
    String status;
    @CreatedDate
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date transaction_date = new Date();
    String balance_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTransaction_value() {
        return transaction_value;
    }

    public void setTransaction_value(Double transaction_value) {
        this.transaction_value = transaction_value;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getBalance_id() {
        return balance_id;
    }

    public void setBalance_id(String balance_id) {
        this.balance_id = balance_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
