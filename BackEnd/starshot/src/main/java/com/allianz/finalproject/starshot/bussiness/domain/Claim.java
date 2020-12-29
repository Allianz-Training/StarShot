package com.allianz.finalproject.starshot.bussiness.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "claim_info")
public class Claim {
  @Id
  @Column(name = "policy_number")
  private Integer policy_number;
  @Column(name = "first_name")
  private String first_name;
  @Column(name = "last_name")
  private String last_name;
  @Column(name = "passport_number")
  private String passport_number;
  @Column(name = "national_id")
  private String national_id;
  @Column(name = "phone_country_code")
  private String phone_country_code;
  @Column(name = "phone_number")
  private String phone_number;
  @Column(name = "email")
  private String email;
  @Column(name = "incident")
  private String incident;

  public Claim() {}

  public Claim(Integer policy_number, String first_name, String last_name, String passport_number,
      String national_id, String phone_country_code, String phone_number, String email,
      String incident) {
    this.policy_number = policy_number;
    this.first_name = first_name;
    this.last_name = last_name;
    this.passport_number = passport_number;
    this.national_id = national_id;
    this.phone_country_code = phone_country_code;
    this.phone_number = phone_number;
    this.email = email;
    this.incident = incident;

  }

  @Override
  public String toString() {
    return "Claim [policy_number=" + policy_number + ", first_name=" + first_name + ", last_name="
        + last_name + ", passport_number=" + passport_number + ", national_id=" + national_id
        + ", phone_country_code=" + phone_country_code + ", phone_number=" + phone_number
        + ", email=" + email + ", incident=" + incident + "]";
  }


}
