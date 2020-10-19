package com.SEII.models;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post")

public class Post {

    @Id
    @SequenceGenerator(name = "POST_POSTID_GENERATOR", sequenceName = "public.post_post_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "POST_POSTID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @Column(name = "post_id")

    private Integer id;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person seller_id;

    @OneToOne
    @JoinColumn(name = "category_id", nullable = true)
    private Category category_id;

    @Column(name = "title")

    private String title;

    @Column(name = "product_name")

    private String product_name;

    @Column(name = "image", nullable = true)

    private String image;

    @Column(name = "description")

    private String description;

    @Column(name = "total_review")
    private double total_review;

    @Column(name = "price")
    private Integer price;

    @Column(name = "stock")
    private Integer stock;

    @OneToOne(mappedBy = "cartshop_item_post_id")
    private Cartshop_item cartshop_item;

    @OneToMany(mappedBy = "postReviewed")
    private List<Review> reviews;

    @OneToMany(mappedBy = "postAsked")
    private List<Question> questions;

    public Post() {
    }

    public Post(Category category_id, String title, String product_name, String image,
            String description, Integer price, Integer stock) { //Solo agrego los atributos que usamos por ahora, quito los demas

        
        this.category_id = category_id;
        this.title = title;
        this.product_name = product_name;
        this.image = image;
        this.description = description;
        this.total_review = 0;
        this.price = price;
        this.stock = stock;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getSeller_id() {
        return this.seller_id;
    }

    public void setSeller_id(Person seller_id) {
        this.seller_id = seller_id;
    }

    public Category getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotal_review() {
        return this.total_review;
    }

    public void setTotal_review(double total_review) {
        this.total_review = total_review;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Cartshop_item getCartshop_item() {
        return this.cartshop_item;
    }

    public void setCartshop_item(Cartshop_item cartshop_item) {
        this.cartshop_item = cartshop_item;
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

    public Post id(Integer id) {
        this.id = id;
        return this;
    }

    public Post seller_id(Person seller_id) {
        this.seller_id = seller_id;
        return this;
    }

    public Post category_id(Category category_id) {
        this.category_id = category_id;
        return this;
    }

    public Post title(String title) {
        this.title = title;
        return this;
    }

    public Post product_name(String product_name) {
        this.product_name = product_name;
        return this;
    }

    public Post image(String image) {
        this.image = image;
        return this;
    }

    public Post description(String description) {
        this.description = description;
        return this;
    }

    public Post total_review(double total_review) {
        this.total_review = total_review;
        return this;
    }

    public Post price(Integer price) {
        this.price = price;
        return this;
    }

    public Post stock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public Post cartshop_item(Cartshop_item cartshop_item) {
        this.cartshop_item = cartshop_item;
        return this;
    }

    public Post reviews(List<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public Post questions(List<Question> questions) {
        this.questions = questions;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Post)) {
            return false;
        }
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(seller_id, post.seller_id)
                && Objects.equals(category_id, post.category_id) && Objects.equals(title, post.title)
                && Objects.equals(product_name, post.product_name) && Objects.equals(image, post.image)
                && Objects.equals(description, post.description) && total_review == post.total_review
                && Objects.equals(price, post.price) && Objects.equals(stock, post.stock)
                && Objects.equals(cartshop_item, post.cartshop_item) && Objects.equals(reviews, post.reviews)
                && Objects.equals(questions, post.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seller_id, category_id, title, product_name, image, description, total_review, price,
                stock, cartshop_item, reviews, questions);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", seller_id='" + getSeller_id() + "'" + ", category_id='"
                + getCategory_id() + "'" + ", title='" + getTitle() + "'" + ", product_name='" + getProduct_name() + "'"
                + ", image='" + getImage() + "'" + ", description='" + getDescription() + "'" + ", total_review='"
                + getTotal_review() + "'" + ", price='" + getPrice() + "'" + ", stock='" + getStock() + "'"
                + ", cartshop_item='" + getCartshop_item() + "'" + ", reviews='" + getReviews() + "'" + ", questions='"
                + getQuestions() + "'" + "}";
    }
}
