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
@Table(name = "review")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "person_id")
  private Person reviewByPerson;

  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post postReviewed;

  @Column(name = "value")
  private Integer value;

  @Column(name = "text")
  private String text;


  public Review() {
  }

  public Review(Integer id, Person reviewByPerson, Post postReviewed, Integer value, String text) {
    this.id = id;
    this.reviewByPerson = reviewByPerson;
    this.postReviewed = postReviewed;
    this.value = value;
    this.text = text;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Person getReviewByPerson() {
    return this.reviewByPerson;
  }

  public void setReviewByPerson(Person reviewByPerson) {
    this.reviewByPerson = reviewByPerson;
  }

  public Post getPostReviewed() {
    return this.postReviewed;
  }

  public void setPostReviewed(Post postReviewed) {
    this.postReviewed = postReviewed;
  }

  public Integer getValue() {
    return this.value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Review id(Integer id) {
    this.id = id;
    return this;
  }

  public Review reviewByPerson(Person reviewByPerson) {
    this.reviewByPerson = reviewByPerson;
    return this;
  }

  public Review postReviewed(Post postReviewed) {
    this.postReviewed = postReviewed;
    return this;
  }

  public Review value(Integer value) {
    this.value = value;
    return this;
  }

  public Review text(String text) {
    this.text = text;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Review)) {
            return false;
        }
        Review review = (Review) o;
        return Objects.equals(id, review.id) && Objects.equals(reviewByPerson, review.reviewByPerson) && Objects.equals(postReviewed, review.postReviewed) && Objects.equals(value, review.value) && Objects.equals(text, review.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, reviewByPerson, postReviewed, value, text);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", reviewByPerson='" + getReviewByPerson() + "'" +
      ", postReviewed='" + getPostReviewed() + "'" +
      ", value='" + getValue() + "'" +
      ", text='" + getText() + "'" +
      "}";
  }

}
