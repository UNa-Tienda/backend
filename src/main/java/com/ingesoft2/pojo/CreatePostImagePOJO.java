package com.ingesoft2.pojo;

import java.io.File;

public class CreatePostImagePOJO {

    private String title;

    private String productName;

    private File image;

    private String description;

    private Integer price;

    private Integer stock;

    public CreatePostImagePOJO() {
        //Creacion en vacio para comenzar a crear el postPOJO.
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

}
