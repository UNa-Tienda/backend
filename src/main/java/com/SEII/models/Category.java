package com.SEII.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  @Column(name = "category_id")

  private Integer id;

  @Column(name = "name")

  private String name;

  @Column(name = "image")

  private String image;

  @OneToMany(mappedBy = "category_id")
  private List<Post> posts;

  @OneToMany(mappedBy = "category_coupon_id")
  private List<Coupon> coupons;
  

  public Category() {
  }

  public Category(Integer id, String name, String image, List<Post> posts, List<Coupon> coupons) {
    this.id = id;
    this.name = name;
    this.image = image;
    this.posts = posts;
    this.coupons = coupons;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImage() {
    return this.image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public List<Post> getPosts() {
    return this.posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  public List<Coupon> getCoupons() {
    return this.coupons;
  }

  public void setCoupons(List<Coupon> coupons) {
    this.coupons = coupons;
  }

  public Category id(Integer id) {
    this.id = id;
    return this;
  }

  public Category name(String name) {
    this.name = name;
    return this;
  }

  public Category image(String image) {
    this.image = image;
    return this;
  }

  public Category posts(List<Post> posts) {
    this.posts = posts;
    return this;
  }

  public Category coupons(List<Coupon> coupons) {
    this.coupons = coupons;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Category)) {
            return false;
        }
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name) && Objects.equals(image, category.image) && Objects.equals(posts, category.posts) && Objects.equals(coupons, category.coupons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, image, posts, coupons);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", image='" + getImage() + "'" +
      ", posts='" + getPosts() + "'" +
      ", coupons='" + getCoupons() + "'" +
      "}";
  }
  
}
