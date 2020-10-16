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

    public Integer id;

    @Column(name = "u_id")
    //Aqui iria un metodo que toma la id del usuario creador del post ?
    public Integer u_id;



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

    public Post(Integer id,Integer u_id, Integer category_id, String title, String product_name, String image, String description, Integer price, Integer stock) {

        this.id = id;

        this.u_id = u_id;

        this.category_id = category_id;

        this.title = title;
        
        this.product_name = product_name;

        this.image = image;

        this.description = description;

        this.total_review = 0;

        this.price = price;

        this.stock = stock;

        

    }
    
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(id));
        builder.append(", ");
        builder.append(String.valueOf(u_id));
        builder.append(", ");
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
