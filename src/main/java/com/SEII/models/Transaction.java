package com.SEII.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
  
  @Id
  @SequenceGenerator(name = "TRANSACTION_TRANSACTIONID_GENERATOR", sequenceName = "public.transaction_transaction_id_seq", allocationSize = 1)
  @GeneratedValue(generator = "TRANSACTION_TRANSACTIONID_GENERATOR", strategy = GenerationType.SEQUENCE)
  @Column(name = "transaction_id")
  private Integer id;

  
  @ManyToOne
  @JoinColumn(name = "person_id")
  private PersonDTO buyerPerson;

  // @ManyToOne
  // @JoinColumn( name = "person_id", insertable = false, updatable = false)
  // private Person sellerPerson;

  @OneToOne
  @JoinColumn(name = "post_id", insertable = false, updatable = false)
  private Post post_id;

  @Column(name = "stock_price")
  private Integer stock_price;

  @Column(name = "quantity")
  private Integer quantity;




  public Transaction() {
  }

  public Transaction(Integer id, PersonDTO buyerPerson, Post product_id, Integer stock_price, Integer quantity) {
    this.id = id;
    this.buyerPerson = buyerPerson;
    this.post_id = product_id;
    this.stock_price = stock_price;
    this.quantity = quantity;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public PersonDTO getBuyerPerson() {
    return this.buyerPerson;
  }

  public void setBuyerPerson(PersonDTO buyerPerson) {
    this.buyerPerson = buyerPerson;
  }

  public Post getPost_id() {
    return this.post_id;
  }

  public void setPost_id(Post product_id) {
    this.post_id=product_id;
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

  public Transaction buyerPerson(PersonDTO buyerPerson) {
    this.buyerPerson = buyerPerson;
    return this;
  }

  public Transaction product_id(Post product_id) {
    this.post_id = product_id;
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
        return Objects.equals(id, transaction.id) && Objects.equals(buyerPerson, transaction.buyerPerson) && Objects.equals(post_id, transaction.post_id) && Objects.equals(stock_price, transaction.stock_price) && Objects.equals(quantity, transaction.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, buyerPerson, post_id, stock_price, quantity);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", buyerPerson='" + getBuyerPerson() + "'" +
      ", product_id='" + getPost_id() + "'" +
      ", stock_price='" + getStock_price() + "'" +
      ", quantity='" + getQuantity() + "'" +
      "}";
  }
    
}
