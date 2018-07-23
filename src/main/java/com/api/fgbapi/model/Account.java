package com.api.fgbapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "master_account")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"date_created", "date_updated"},
        allowGetters = true)
public class Account {
    @Id
    String id;
    String first_name;
    String last_name;
    Date dob;
    String phone;
    String email;
    String password;
    Boolean live;
    Boolean demo;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    Date date_created;
    String address;
    String id_card;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    Date date_updated;
    String ref_id;
    String acc_type;
    String acc_owner;
    String pref_name;
    String country;
    String city;
    String province;
    String zip_code;
    String security_question;
    String security_answer;
    String confirm_security_answer;
    String education;
    String trading_experience;
    String trading_frequency;
    String purpose_of_trading;
    String annual_gross_income;
    String net_worth;
    String income_source;
    String is_muslim;
    String public_position;
    String detail_public_position;
    String family_public_position;
    String detail_family_public_position;
    String leverage;
    String pref_language;
    String proof_of_identity;
    String proof_of_residence;
    String open_ib_account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public Boolean getDemo() {
        return demo;
    }

    public void setDemo(Boolean demo) {
        this.demo = demo;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public Date getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(Date date_updated) {
        this.date_updated = date_updated;
    }

    public String getRef_id() {
        return ref_id;
    }

    public void setRef_id(String ref_id) {
        this.ref_id = ref_id;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }

    public String getAcc_owner() {
        return acc_owner;
    }

    public void setAcc_owner(String acc_owner) {
        this.acc_owner = acc_owner;
    }

    public String getPref_name() {
        return pref_name;
    }

    public void setPref_name(String pref_name) {
        this.pref_name = pref_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getSecurity_question() {
        return security_question;
    }

    public void setSecurity_question(String security_question) {
        this.security_question = security_question;
    }

    public String getSecurity_answer() {
        return security_answer;
    }

    public void setSecurity_answer(String security_answer) {
        this.security_answer = security_answer;
    }

    public String getConfirm_security_answer() {
        return confirm_security_answer;
    }

    public void setConfirm_security_answer(String confirm_security_answer) {
        this.confirm_security_answer = confirm_security_answer;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTrading_experience() {
        return trading_experience;
    }

    public void setTrading_experience(String trading_experience) {
        this.trading_experience = trading_experience;
    }

    public String getTrading_frequency() {
        return trading_frequency;
    }

    public void setTrading_frequency(String trading_frequency) {
        this.trading_frequency = trading_frequency;
    }

    public String getPurpose_of_trading() {
        return purpose_of_trading;
    }

    public void setPurpose_of_trading(String purpose_of_trading) {
        this.purpose_of_trading = purpose_of_trading;
    }

    public String getAnnual_gross_income() {
        return annual_gross_income;
    }

    public void setAnnual_gross_income(String annual_gross_income) {
        this.annual_gross_income = annual_gross_income;
    }

    public String getNet_worth() {
        return net_worth;
    }

    public void setNet_worth(String net_worth) {
        this.net_worth = net_worth;
    }

    public String getIncome_source() {
        return income_source;
    }

    public void setIncome_source(String income_source) {
        this.income_source = income_source;
    }

    public String getIs_muslim() {
        return is_muslim;
    }

    public void setIs_muslim(String is_muslim) {
        this.is_muslim = is_muslim;
    }

    public String getPublic_position() {
        return public_position;
    }

    public void setPublic_position(String public_position) {
        this.public_position = public_position;
    }

    public String getDetail_public_position() {
        return detail_public_position;
    }

    public void setDetail_public_position(String detail_public_position) {
        this.detail_public_position = detail_public_position;
    }

    public String getFamily_public_position() {
        return family_public_position;
    }

    public void setFamily_public_position(String family_public_position) {
        this.family_public_position = family_public_position;
    }

    public String getDetail_family_public_position() {
        return detail_family_public_position;
    }

    public void setDetail_family_public_position(String detail_family_public_position) {
        this.detail_family_public_position = detail_family_public_position;
    }

    public String getLeverage() {
        return leverage;
    }

    public void setLeverage(String leverage) {
        this.leverage = leverage;
    }

    public String getPref_language() {
        return pref_language;
    }

    public void setPref_language(String pref_language) {
        this.pref_language = pref_language;
    }

    public String getProof_of_identity() {
        return proof_of_identity;
    }

    public void setProof_of_identity(String proof_of_identity) {
        this.proof_of_identity = proof_of_identity;
    }

    public String getProof_of_residence() {
        return proof_of_residence;
    }

    public void setProof_of_residence(String proof_of_residence) {
        this.proof_of_residence = proof_of_residence;
    }

    public String getOpen_ib_account() {
        return open_ib_account;
    }

    public void setOpen_ib_account(String open_ib_account) {
        this.open_ib_account = open_ib_account;
    }
}
