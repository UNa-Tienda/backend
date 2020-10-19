package com.SEII.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table(name = "person")

public class Person {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")

    public Long id;


    @Column(name = "name")

    public String name;
    

    @Column(name = "username")

    public String username;
    

    @Column(name = "email")

    public String email;
    
    
    @Column(name = "password")

    public String password;
    
    
    @Column(name = "photo")

    public String photo;
    
    
    @Column(name = "location")

    public String location;

    @JsonIgnore 

    @OneToMany( mappedBy = "person" )
    
    private List<Post> posts;


    public Person() {}

    public Person(long id, String name, String username, String email, String password, String photo, String location) {

        this.id = id;

        this.name = name;

        this.username = username;
        
        this.email = email;
        
        this.password = password;
        
        this.photo = photo;
        
        this.location = location;

    }


    
    
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(id));
        builder.append(", ");
        builder.append(name);
        builder.append(", ");
        builder.append(username);
        builder.append(", ");
        builder.append(email);
        builder.append(", ");
        builder.append(photo);
        builder.append(", ");
        builder.append(location);
        builder.append(", ");

        return builder.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
