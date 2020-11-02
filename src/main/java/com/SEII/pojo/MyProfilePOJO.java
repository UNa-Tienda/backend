package com.SEII.pojo;

import com.SEII.models.PersonDTO;

public class MyProfilePOJO {
    private String name;
    private String username;
    private String email;
    private String location;

    public MyProfilePOJO MyProfilePOJO(PersonDTO person) {
        MyProfilePOJO person2 = new MyProfilePOJO();
        
        person2.setName(person.getName());
        person2.setUsername(person.getUsername());
        person2.setEmail(person.getEmail());
        person2.setLocation(person.getLocation());
        return person2;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
    
}
