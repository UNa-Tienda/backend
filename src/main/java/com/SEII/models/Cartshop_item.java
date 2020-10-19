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
import javax.persistence.Table;

@Entity
@Table(name = "cartshop_item")
public class Cartshop_item {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "cartshop_id")
  private Cartshop cartshop;

  @OneToOne
  @JoinColumn(name = "post_id", insertable = false, updatable = false)
  private Post cartshop_item_post_id;

  @Column(name = "quantity")
  private Integer quantity;


  public Cartshop_item() {
  }

  public Cartshop_item(Integer id, Cartshop cartshop, Post cartshop_item_post_id, Integer quantity) {
    this.id = id;
    this.cartshop = cartshop;
    this.cartshop_item_post_id = cartshop_item_post_id;
    this.quantity = quantity;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Cartshop getCartshop() {
    return this.cartshop;
  }

  public void setCartshop(Cartshop cartshop) {
    this.cartshop = cartshop;
  }

  public Post getCartshop_item_post_id() {
    return this.cartshop_item_post_id;
  }

  public void setCartshop_item_post_id(Post cartshop_item_post_id) {
    this.cartshop_item_post_id = cartshop_item_post_id;
  }

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Cartshop_item id(Integer id) {
    this.id = id;
    return this;
  }

  public Cartshop_item cartshop(Cartshop cartshop) {
    this.cartshop = cartshop;
    return this;
  }

  public Cartshop_item cartshop_item_post_id(Post cartshop_item_post_id) {
    this.cartshop_item_post_id = cartshop_item_post_id;
    return this;
  }

  public Cartshop_item quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cartshop_item)) {
            return false;
        }
        Cartshop_item cartshop_item = (Cartshop_item) o;
        return Objects.equals(id, cartshop_item.id) && Objects.equals(cartshop, cartshop_item.cartshop) && Objects.equals(cartshop_item_post_id, cartshop_item.cartshop_item_post_id) && Objects.equals(quantity, cartshop_item.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cartshop, cartshop_item_post_id, quantity);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", cartshop='" + getCartshop() + "'" +
      ", cartshop_item_post_id='" + getCartshop_item_post_id() + "'" +
      ", quantity='" + getQuantity() + "'" +
      "}";
  }

}
