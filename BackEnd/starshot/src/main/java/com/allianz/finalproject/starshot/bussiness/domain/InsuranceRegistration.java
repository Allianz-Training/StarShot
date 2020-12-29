package com.allianz.finalproject.starshot.bussiness.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_account")
public class InsuranceRegistration {

  // 1
  @Id
  @Column(name = "policy_number")
  private Integer policy_number;
  // 2
  @Column(name = "event_code")
  private Integer event_code;
  // 3
  @Column(name = "package_code")
  private Integer package_code;
  // 4
  @Column(name = "title_name")
  private String title_name;
  // 5
  @Column(name = "first_name")
  private String first_name;
  // 6
  @Column(name = "last_name")
  private String last_name;
  // 7
  @Column(name = "national_id")
  private String national_id;
  // 8
  @Column(name = "passport_number")
  private String passport_number;
  // 9
  @Column(name = "gender")
  private String gender;
  // 10
  @Column(name = "birth_date")
  private Date birth_date;
  // 11
  @Column(name = "phone_number")
  private String phone_number;
  // 12
  @Column(name = "email")
  private String email;
  // 13
  @Column(name = "nationality")
  private String nationality;
  // 14
  @Column(name = "address")
  private String address;
  // 15
  @Column(name = "promaotion_code")
  private String promaotion_code;

  // 17
  @Column(name = "total_price")
  private Float total_price;
  // 18

  // 19
  @Column(name = "event_date")
  private Date event_date;
  // 20
  @Column(name = "event_name")
  private String event_name;
  // 21
  @Column(name = "sex")
  private String sex;


  @Override
  public String toString() {
    return "InsuranceRegistration [policy_number=" + policy_number + ", event_code=" + event_code
        + ", package_code=" + package_code + ", title_name=" + title_name + ", first_name="
        + first_name + ", last_name=" + last_name + ", national_id=" + national_id
        + ", passport_number=" + passport_number + ", gender=" + gender + ", birth_date="
        + birth_date + ", phone_number=" + phone_number + ", email=" + email + ", nationality="
        + nationality + ", address=" + address + ", promaotion_code=" + promaotion_code
        + ", total_price=" + total_price + ", event_date=" + event_date + ", event_name="
        + event_name + ", sex=" + sex + "]";
  }

  public Integer getPolicy_number() {
    return policy_number;
  }

  public void setPolicy_number(Integer policy_number) {
    this.policy_number = policy_number;
  }

  public Integer getEvent_code() {
    return event_code;
  }

  public void setEvent_code(Integer event_code) {
    this.event_code = event_code;
  }

  public Integer getPackage_code() {
    return package_code;
  }

  public void setPackage_code(Integer package_code) {
    this.package_code = package_code;
  }

  public String getTitle_name() {
    return title_name;
  }

  public void setTitle_name(String title_name) {
    this.title_name = title_name;
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

  public String getNational_id() {
    return national_id;
  }

  public void setNational_id(String national_id) {
    this.national_id = national_id;
  }

  public String getPassport_number() {
    return passport_number;
  }

  public void setPassport_number(String passport_number) {
    this.passport_number = passport_number;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getBirth_date() {
    return birth_date;
  }

  public void setBirth_date(Date birth_date) {
    this.birth_date = birth_date;
  }

  public String getPhone_number() {
    return phone_number;
  }

  public void setPhone_number(String phone_number) {
    this.phone_number = phone_number;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPromaotion_code() {
    return promaotion_code;
  }

  public void setPromaotion_code(String promaotion_code) {
    this.promaotion_code = promaotion_code;
  }

  public Float getTotal_price() {
    return total_price;
  }

  public void setTotal_price(Float total_price) {
    this.total_price = total_price;
  }

  public Date getEvent_date() {
    return event_date;
  }

  public void setEvent_date(Date event_date) {
    this.event_date = event_date;
  }

  public String getEvent_name() {
    return event_name;
  }

  public void setEvent_name(String event_name) {
    this.event_name = event_name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }



  public InsuranceRegistration() {}

  public InsuranceRegistration(Integer policy_number, Integer event_code, Integer package_code,
      String title_name, String first_name, String last_name, String national_id,
      String passport_number, String gender, Date Date, String phone_number, String email,
      String nationality, String address, String promaotion_code, Float total_price,
      Date event_date, String event_name, String sex) {}


}

