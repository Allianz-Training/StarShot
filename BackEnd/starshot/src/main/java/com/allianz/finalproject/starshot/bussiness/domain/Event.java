package com.allianz.finalproject.starshot.bussiness.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event_info")

public class Event {
  @Id
  @Column(name = "event_code")
  private Integer event_code;
  @Column(name = "event_type")
  private String event_type;
  @Column(name = "event_date")
  private Date event_date;
  @Column(name = "event_name")
  private String event_name;
  @Column(name = "event_location")
  private String event_location;
  @Column(name = "package_a_price")
  private String package_a_price;
  @Column(name = "package_b_price")
  private String package_b_price;

  public Event() {}

  public Event(Integer event_code, String event_type, Date event_date, String event_name,
      String event_location, String package_a_price, String package_b_price) {
    super();
    this.event_code = event_code;
    this.event_type = event_type;
    this.event_date = event_date;
    this.event_name = event_name;
    this.event_location = event_location;
    this.package_a_price = package_a_price;
    this.package_b_price = package_b_price;
  }

  public Integer getEvent_code() {
    return event_code;
  }

  public void setEvent_code(Integer event_code) {
    this.event_code = event_code;
  }

  public String getEvent_type() {
    return event_type;
  }

  public void setEvent_type(String event_type) {
    this.event_type = event_type;
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

  public String getEvent_location() {
    return event_location;
  }

  public void setEvent_location(String event_location) {
    this.event_location = event_location;
  }

  public String getPackage_a_price() {
    return package_a_price;
  }

  public void setPackage_a_price(String package_a_price) {
    this.package_a_price = package_a_price;
  }

  public String getPackage_b_price() {
    return package_b_price;
  }

  public void setPackage_b_price(String package_b_price) {
    this.package_b_price = package_b_price;
  }

  @Override
  public String toString() {
    return "Event [event_code=" + event_code + ", event_type=" + event_type + ", event_date="
        + event_date + ", event_name=" + event_name + ", event_location=" + event_location
        + ", package_a_price=" + package_a_price + ", package_b_price=" + package_b_price + "]";
  }



}

