package com.SEII.models;

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
@Table(name = "transaction")
public class Transaction {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "transaction_id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "person_id", insertable = false, updatable = false)
  private Person buyerPerson;

  @ManyToOne
  @JoinColumn( name = "person_id", insertable = false, updatable = false)
  private Person sellerPerson;

  @Column(name = "product")
  private String product;

  @Column(name = "stock_price")
  private Integer stock_price;

  @Column(name = "quantity")
  private Integer quantity;


  public Transaction() {
  }

  public Transaction(Integer id, Person buyerPerson, Person sellerPerson, String product, Integer stock_price, Integer quantity) {
    this.id = id;
    this.buyerPerson = buyerPerson;
    this.sellerPerson = sellerPerson;
    this.product = product;
    this.stock_price = stock_price;
    this.quantity = quantity;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Person getBuyerPerson() {
    return this.buyerPerson;
  }

  public void setBuyerPerson(Person buyerPerson) {
    this.buyerPerson = buyerPerson;
  }

  public Person getSellerPerson() {
    return this.sellerPerson;
  }

  public void setSellerPerson(Person sellerPerson) {
    this.sellerPerson = sellerPerson;
  }

  public String getProduct() {
    return this.product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public Integer getStock_price() {
    return this.stock_price;
  }

  public void setStock_price(Integer stock_price) {
    this.stock_price = stock_price;
  }

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Transaction id(Integer id) {
    this.id = id;
    return this;
  }

  public Transaction buyerPerson(Person buyerPerson) {
    this.buyerPerson = buyerPerson;
    return this;
  }

  public Transaction sellerPerson(Person sellerPerson) {
    this.sellerPerson = sellerPerson;
    return this;
  }

  public Transaction product(String product) {
    this.product = product;
    return this;
  }

  public Transaction stock_price(Integer stock_price) {
    this.stock_price = stock_price;
    return this;
  }

  public Transaction quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        return Objects.equals(id, transaction.id) && Objects.equals(buyerPerson, transaction.buyerPerson) && Objects.equals(sellerPerson, transaction.sellerPerson) && Objects.equals(product, transaction.product) && Objects.equals(stock_price, transaction.stock_price) && Objects.equals(quantity, transaction.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, buyerPerson, sellerPerson, product, stock_price, quantity);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", buyerPerson='" + getBuyerPerson() + "'" +
      ", sellerPerson='" + getSellerPerson() + "'" +
      ", product='" + getProduct() + "'" +
      ", stock_price='" + getStock_price() + "'" +
      ", quantity='" + getQuantity() + "'" +
      "}";
  }

}
