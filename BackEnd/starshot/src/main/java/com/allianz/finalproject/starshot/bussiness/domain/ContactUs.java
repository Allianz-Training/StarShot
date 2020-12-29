package com.allianz.finalproject.starshot.bussiness.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_us")
public class ContactUs {
  @Id
  @Column(name = "idcontact_us")
  private Integer idcontact_us;
  @Column(name = "name")
  private String name;
  @Column(name = "email")
  private String email;
  @Column(name = "phone_country_code")
  private String phone_country_code;
  @Column(name = "phone_number")
  private String phone_number;
  @Column(name = "message")
  private String message;

  public ContactUs() {}

  public ContactUs(Integer idcontact_us, String name, String email, String phone_country_code,
      String phone_number, String message) {
    this.idcontact_us = idcontact_us;
    this.name = name;
    this.email = email;
    this.phone_country_code = phone_country_code;
    this.phone_number = phone_number;
    this.message = message;
  }

  public Integer getIdcontact_us() {
    return idcontact_us;
  }

  public void setIdcontact_us(Integer idcontact_us) {
    this.idcontact_us = idcontact_us;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone_country_code() {
    return phone_country_code;
  }

  public void setPhone_country_code(String phone_country_code) {
    this.phone_country_code = phone_country_code;
  }

  public String getPhone_number() {
    return phone_number;
  }

  public void setPhone_number(String phone_number) {
    this.phone_number = phone_number;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "ContactUs [idcontact_us=" + idcontact_us + ", name=" + name + ", email=" + email
        + ", phone_country_code=" + phone_country_code + ", phone_number=" + phone_number
        + ", message=" + message + "]";
  }

}
