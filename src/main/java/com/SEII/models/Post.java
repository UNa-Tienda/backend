package com.SEII.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  @Column(name = "id")

  public Integer id;

  @Column(name = "user_id")

  public Integer user_id;

  @Column(name = "category_id")

  public Integer category_id;

  @Column(name = "title")

  public String title;

  @Column(name = "product_name")

  public String product_name;

  @Column(name = "image")

  public String image;

  @Column(name = "description")

  public String description;

  public Post() {
  }

  public Post(Integer id, Integer user_id, Integer category_id, String title, String product_name, String image, String description){
    this.id = id;

    this.user_id = user_id;

    this.category_id = category_id;

    this.title = title;

    this.product_name = product_name;

    this.image = image;

    this.description = description;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append(String.valueOf(id));
    builder.append(", ");
    builder.append(user_id);
    builder.append(", ");
    builder.append(category_id);
    builder.append(", ");
    builder.append(title);
    builder.append(", ");
    builder.append(product_name);
    builder.append(", ");
    builder.append(image);
    builder.append(", ");
    builder.append(description);
    builder.append(", ");

    return builder.toString();
  }
}
