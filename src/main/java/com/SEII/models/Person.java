package com.SEII.models;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "person")

public class Person {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "person_id")

    private Integer id;

    @OneToOne
    @JoinColumn(name = "role_id")
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
    
    
    @Column(name = "address")

    private String address;
    
    @Column(name = "paypal_id")
    private String paypal_id;


    @OneToOne(mappedBy = "seller_id")
    private Post post;

    @OneToMany(mappedBy = "buyerPerson")
    private List<Transaction> buyerTransactions;

    @OneToMany(mappedBy = "sellerPerson")
    private List<Transaction> sellerTransactions;

    @OneToOne(mappedBy = "personCartshop")
    private Cartshop cartshop;

    @OneToMany(mappedBy = "reviewByPerson")
    private List<Review> reviews;

    @OneToMany(mappedBy = "personAsk")
    private List<Question> questions;

    @OneToMany(mappedBy = "personAnswer")
    private List<Answer> answers;



    public Person() {
    }

    public Person(Integer id, Role role_id, String name, String username, String email, String password, String photo, String address, String paypal_id, Post post, List<Transaction> buyerTransactions, List<Transaction> sellerTransactions, Cartshop cartshop, List<Review> reviews, List<Question> questions, List<Answer> answers) {
        this.id = id;
        this.role_id = role_id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.address = address;
        this.paypal_id = paypal_id;
        this.post = post;
        this.buyerTransactions = buyerTransactions;
        this.sellerTransactions = sellerTransactions;
        this.cartshop = cartshop;
        this.reviews = reviews;
        this.questions = questions;
        this.answers = answers;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaypal_id() {
        return this.paypal_id;
    }

    public void setPaypal_id(String paypal_id) {
        this.paypal_id = paypal_id;
    }

    public Post getPost() {
        return this.post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Transaction> getBuyerTransactions() {
        return this.buyerTransactions;
    }

    public void setBuyerTransactions(List<Transaction> buyerTransactions) {
        this.buyerTransactions = buyerTransactions;
    }

    public List<Transaction> getSellerTransactions() {
        return this.sellerTransactions;
    }

    public void setSellerTransactions(List<Transaction> sellerTransactions) {
        this.sellerTransactions = sellerTransactions;
    }

    public Cartshop getCartshop() {
        return this.cartshop;
    }

    public void setCartshop(Cartshop cartshop) {
        this.cartshop = cartshop;
    }

    public List<Review> getReviews() {
        return this.reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return this.answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Person id(Integer id) {
        this.id = id;
        return this;
    }

    public Person role_id(Role role_id) {
        this.role_id = role_id;
        return this;
    }

    public Person name(String name) {
        this.name = name;
        return this;
    }

    public Person username(String username) {
        this.username = username;
        return this;
    }

    public Person email(String email) {
        this.email = email;
        return this;
    }

    public Person password(String password) {
        this.password = password;
        return this;
    }

    public Person photo(String photo) {
        this.photo = photo;
        return this;
    }

    public Person address(String address) {
        this.address = address;
        return this;
    }

    public Person paypal_id(String paypal_id) {
        this.paypal_id = paypal_id;
        return this;
    }

    public Person post(Post post) {
        this.post = post;
        return this;
    }

    public Person buyerTransactions(List<Transaction> buyerTransactions) {
        this.buyerTransactions = buyerTransactions;
        return this;
    }

    public Person sellerTransactions(List<Transaction> sellerTransactions) {
        this.sellerTransactions = sellerTransactions;
        return this;
    }

    public Person cartshop(Cartshop cartshop) {
        this.cartshop = cartshop;
        return this;
    }

    public Person reviews(List<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public Person questions(List<Question> questions) {
        this.questions = questions;
        return this;
    }

    public Person answers(List<Answer> answers) {
        this.answers = answers;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(role_id, person.role_id) && Objects.equals(name, person.name) && Objects.equals(username, person.username) && Objects.equals(email, person.email) && Objects.equals(password, person.password) && Objects.equals(photo, person.photo) && Objects.equals(address, person.address) && Objects.equals(paypal_id, person.paypal_id) && Objects.equals(post, person.post) && Objects.equals(buyerTransactions, person.buyerTransactions) && Objects.equals(sellerTransactions, person.sellerTransactions) && Objects.equals(cartshop, person.cartshop) && Objects.equals(reviews, person.reviews) && Objects.equals(questions, person.questions) && Objects.equals(answers, person.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role_id, name, username, email, password, photo, address, paypal_id, post, buyerTransactions, sellerTransactions, cartshop, reviews, questions, answers);
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
            ", address='" + getAddress() + "'" +
            ", paypal_id='" + getPaypal_id() + "'" +
            ", post='" + getPost() + "'" +
            ", buyerTransactions='" + getBuyerTransactions() + "'" +
            ", sellerTransactions='" + getSellerTransactions() + "'" +
            ", cartshop='" + getCartshop() + "'" +
            ", reviews='" + getReviews() + "'" +
            ", questions='" + getQuestions() + "'" +
            ", answers='" + getAnswers() + "'" +
            "}";
    }

}
