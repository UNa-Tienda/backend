package com.SEII.models;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "coupon")
public class Coupon {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  @Column(name = "coupon_id")

  private Integer id;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category_coupon_id;

  @Column(name = "start_date")
  private Date start_date;

  @Column(name = "end_date")
  private Date end_date;

  @Column(name = "amount")
  private Integer amount;

  @Column(name = "code")
  private String code;


  public Coupon() {
  }

  public Coupon(Integer id, Category category_coupon_id, Date start_date, Date end_date, Integer amount, String code) {
    this.id = id;
    this.category_coupon_id = category_coupon_id;
    this.start_date = start_date;
    this.end_date = end_date;
    this.amount = amount;
    this.code = code;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Category getCategory_coupon_id() {
    return this.category_coupon_id;
  }

  public void setCategory_coupon_id(Category category_coupon_id) {
    this.category_coupon_id = category_coupon_id;
  }

  public Date getStart_date() {
    return this.start_date;
  }

  public void setStart_date(Date start_date) {
    this.start_date = start_date;
  }

  public Date getEnd_date() {
    return this.end_date;
  }

  public void setEnd_date(Date end_date) {
    this.end_date = end_date;
  }

  public Integer getAmount() {
    return this.amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Coupon id(Integer id) {
    this.id = id;
    return this;
  }

  public Coupon category_coupon_id(Category category_coupon_id) {
    this.category_coupon_id = category_coupon_id;
    return this;
  }

  public Coupon start_date(Date start_date) {
    this.start_date = start_date;
    return this;
  }

  public Coupon end_date(Date end_date) {
    this.end_date = end_date;
    return this;
  }

  public Coupon amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  public Coupon code(String code) {
    this.code = code;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Coupon)) {
            return false;
        }
        Coupon coupon = (Coupon) o;
        return Objects.equals(id, coupon.id) && Objects.equals(category_coupon_id, coupon.category_coupon_id) && Objects.equals(start_date, coupon.start_date) && Objects.equals(end_date, coupon.end_date) && Objects.equals(amount, coupon.amount) && Objects.equals(code, coupon.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, category_coupon_id, start_date, end_date, amount, code);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", category_coupon_id='" + getCategory_coupon_id() + "'" +
      ", start_date='" + getStart_date() + "'" +
      ", end_date='" + getEnd_date() + "'" +
      ", amount='" + getAmount() + "'" +
      ", code='" + getCode() + "'" +
      "}";
  }

}
