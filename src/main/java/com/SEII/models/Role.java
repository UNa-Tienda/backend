package com.SEII.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
  @Id

  @GeneratedValue(strategy = GenerationType.AUTO)

  @Column(name = "role_id")

  private Integer id;

  @Column(name = "name")
  private String name;

  @OneToOne(mappedBy = "role_id")
  private Person person;


  public Role() {
  }

  public Role(Integer id, String name, Person person) {
    this.id = id;
    this.name = name;
    this.person = person;
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

  public Person getPerson() {
    return this.person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Role id(Integer id) {
    this.id = id;
    return this;
  }

  public Role name(String name) {
    this.name = name;
    return this;
  }

  public Role person(Person person) {
    this.person = person;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Role)) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(name, role.name) && Objects.equals(person, role.person);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, person);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", person='" + getPerson() + "'" +
      "}";
  }

}
