package com.SEII.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "post")

public class Post {


    @Id

    @SequenceGenerator( name = "POST_POSTID_GENERATOR", sequenceName = "public.post_post_id_seq", allocationSize = 1 )

    @GeneratedValue( generator = "POST_POSTID_GENERATOR", strategy = GenerationType.SEQUENCE )

    @Column( name = "post_id" )

    public Long post_id;

    @ManyToOne

    @JoinColumn( name = "id" )

    private Person person;
    
    @Column(name = "category_id", nullable = true)

    public Integer category_id;
    

    @Column(name = "title", nullable = false)

    public String title;
    

    @Column(name = "product_name", nullable = false)

    public String product_name;
    

    @Column(name = "image", nullable = true)

    public String image;
    
    
    @Column(name = "description", nullable = false)

    public String description;
    
    
    @Column(name = "total_review")

    public float total_review = 0;
    
    
    @Column(name = "price", nullable = false)

    public Integer price;

    @Column(name = "stock", nullable = false)

    public Integer stock;


    public Post() {}

    public Post(Long post_id, Integer category_id, String title, String product_name, String image, String description, Integer price, Integer stock) {

        this.post_id = post_id;

        this.category_id = category_id;

        this.title = title;
        
        this.product_name = product_name;

        this.image = image;

        this.description = description;

        this.total_review = 0;

        this.price = price;

        this.stock = stock;

        

    }
    


    public Long getPost_id() {
		return post_id;
	}


	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public Integer getCategory_id() {
		return category_id;
	}


	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public float getTotal_review() {
		return total_review;
	}


	public void setTotal_review(float total_review) {
		this.total_review = total_review;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(post_id)); // Para evitar confuciones deberiamos trabajar todas las id con un prefijo
        builder.append(", ");
        /*builder.append(String.valueOf(person.id)); // lo ideal seria ponerle todos los getter y setter a Person y poner todos los nombre con eso y no People
        builder.append(", ");*/
        builder.append(String.valueOf(category_id));
        builder.append(", ");
        builder.append(title);
        builder.append(", ");
        builder.append(product_name);
        builder.append(", ");
        builder.append(image);
        builder.append(", ");
        builder.append(description);
        builder.append(", ");
        builder.append(String.valueOf(total_review));
        builder.append(", ");
        builder.append(String.valueOf(price));
        builder.append(", ");
        builder.append(String.valueOf(stock));
        builder.append(", ");

        return builder.toString();
    }

}
