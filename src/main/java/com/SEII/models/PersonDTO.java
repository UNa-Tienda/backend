package com.SEII.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table(name = "person")

public class PersonDTO {

    @Id
    @SequenceGenerator(name = "PERSON_PERSONID_GENERATOR", sequenceName = "public.person_person_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "PERSON_PERSONID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @Column(name = "person_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "role_id", updatable = false)
    private Role role_id;


    @Column(name = "name")

    private String name;
    

    @Column(name = "username")

    private String username;
    

    @Column(name = "email")

    private String email;
    
    
    @Column(name = "password")

    private String password;
    
    
    @Column(name = "photo")

    private String photo;
    
    
    @Column(name = "location")

    private String location;
    
    @Column(name = "paypal_id")
    private String paypal_id;


    @JsonIgnore 
    @OneToMany( mappedBy = "seller_id" )
    private List<Post> posts;

    @OneToMany(mappedBy = "buyerPerson")
    private List<Transaction> buyerTransactions;

    // @OneToMany(mappedBy = "sellerPerson")
    // private List<Transaction> sellerTransactions;

    @OneToOne(mappedBy = "personCartshop")
    private Cartshop cartshop;

    @OneToMany(mappedBy = "reviewByPerson")
    private List<Review> reviews;

    @OneToMany(mappedBy = "personAsk")
    private List<Question> questions;

    @OneToMany(mappedBy = "personAnswer")
    private List<Answer> answers;


    public PersonDTO() {
    }

    public PersonDTO(Integer id, Role role_id, String name, String username, String email, String password, String photo, String location, String paypal_id) {
        this.id = id;
        this.role_id = role_id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.location = location;
        this.paypal_id = paypal_id;
    
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole_id() {
        return this.role_id;
    }

    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPaypal_id() {
        return this.paypal_id;
    }

    public void setPaypal_id(String paypal_id) {
        this.paypal_id = paypal_id;
    }

    public PersonDTO id(Integer id) {
        this.id = id;
        return this;
    }

    public PersonDTO role_id(Role role_id) {
        this.role_id = role_id;
        return this;
    }

    public PersonDTO name(String name) {
        this.name = name;
        return this;
    }

    public PersonDTO username(String username) {
        this.username = username;
        return this;
    }

    public PersonDTO email(String email) {
        this.email = email;
        return this;
    }

    public PersonDTO password(String password) {
        this.password = password;
        return this;
    }

    public PersonDTO photo(String photo) {
        this.photo = photo;
        return this;
    }

    public PersonDTO location(String location) {
        this.location = location;
        return this;
    }

    public PersonDTO paypal_id(String paypal_id) {
        this.paypal_id = paypal_id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PersonDTO)) {
            return false;
        }
        PersonDTO person = (PersonDTO) o;

        return Objects.equals(id, person.id) && Objects.equals(role_id, person.role_id) && Objects.equals(name, person.name) && Objects.equals(username, person.username) && Objects.equals(email, person.email) && Objects.equals(password, person.password) && Objects.equals(photo, person.photo) && Objects.equals(location, person.location) && Objects.equals(paypal_id, person.paypal_id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role_id, name, username, email, password, photo, location, paypal_id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", role_id='" + getRole_id() + "'" +
            ", name='" + getName() + "'" +
            ", username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", photo='" + getPhoto() + "'" +
            ", location='" + getLocation() + "'" +
            ", paypal_id='" + getPaypal_id() + "'" +

            "}";
    }
    
}

