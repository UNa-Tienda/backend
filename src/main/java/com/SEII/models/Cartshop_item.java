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
@Table(name = "cartshop_item")
public class Cartshop_item {

  @Id
  @SequenceGenerator(name = "CARTSHOPITEM_CARTSHOPITEMID_GENERATOR", sequenceName = "public.cartshop_item_cartshop_item_id_seq", allocationSize = 1)
  @GeneratedValue(generator = "CARTSHOPITEM_CARTSHOPITEMID_GENERATOR", strategy = GenerationType.SEQUENCE)
  @Column(name = "cartshop_item_id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "cartshop_id")
  private Cartshop cartshop;

  @OneToOne
  @JoinColumn(name = "post_id", insertable = false, updatable = false)
  private Post cartshopItemPostId;

  @Column(name = "quantity")
  private Integer quantity;


  public Cartshop_item() {
  }

  public Cartshop_item(Integer id, Cartshop cartshop, Post cartshopItemPostId, Integer quantity) {
    this.id = id;
    this.cartshop = cartshop;
    this.cartshopItemPostId = cartshopItemPostId;
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

  public Post getCartshopItemPostId() {
    return this.cartshopItemPostId;
  }

  public void setCartshopItemPostId(Post cartshopItemPostId) {
    this.cartshopItemPostId = cartshopItemPostId;
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

  public Cartshop_item cartshopItemPostId(Post cartshopItemPostId) {
    this.cartshopItemPostId = cartshopItemPostId;
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
        return Objects.equals(id, cartshop_item.id) && Objects.equals(cartshop, cartshop_item.cartshop) && Objects.equals(cartshopItemPostId, cartshop_item.cartshopItemPostId) && Objects.equals(quantity, cartshop_item.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cartshop, cartshopItemPostId, quantity);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", cartshop='" + getCartshop() + "'" +
      ", cartshopItemPostId='" + getCartshopItemPostId() + "'" +
      ", quantity='" + getQuantity() + "'" +
      "}";
  }

}
