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
@Table(name = "answer")
public class Answer {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "question_id")
  private Question question;

  @ManyToOne
  @JoinColumn(name = "person_id")
  private Person personAnswer;

  @Column(name = "text")
  private String text;


  public Answer() {
  }

  public Answer(Integer id, Question question, Person personAnswer, String text) {
    this.id = id;
    this.question = question;
    this.personAnswer = personAnswer;
    this.text = text;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Question getQuestion() {
    return this.question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  public Person getPersonAnswer() {
    return this.personAnswer;
  }

  public void setPersonAnswer(Person personAnswer) {
    this.personAnswer = personAnswer;
  }

  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Answer id(Integer id) {
    this.id = id;
    return this;
  }

  public Answer question(Question question) {
    this.question = question;
    return this;
  }

  public Answer personAnswer(Person personAnswer) {
    this.personAnswer = personAnswer;
    return this;
  }

  public Answer text(String text) {
    this.text = text;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Answer)) {
            return false;
        }
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) && Objects.equals(question, answer.question) && Objects.equals(personAnswer, answer.personAnswer) && Objects.equals(text, answer.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, question, personAnswer, text);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", question='" + getQuestion() + "'" +
      ", personAnswer='" + getPersonAnswer() + "'" +
      ", text='" + getText() + "'" +
      "}";
  }

}
