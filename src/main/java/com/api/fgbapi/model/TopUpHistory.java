package com.api.fgbapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "topup_history")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"topup_date"},
        allowGetters = true)
public class TopUpHistory {
    @Id
    String id;
    Double topup_value;
    @CreatedDate
    Date topup_date;
    Long balance_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTopup_value() {
        return topup_value;
    }

    public void setTopup_value(Double topup_value) {
        this.topup_value = topup_value;
    }

    public Date getTopup_date() {
        return topup_date;
    }

    public void setTopup_date(Date topup_date) {
        this.topup_date = topup_date;
    }

    public Long getBalance_id() {
        return balance_id;
    }

    public void setBalance_id(Long balance_id) {
        this.balance_id = balance_id;
    }
}
