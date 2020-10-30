package com.SEII.pojo;

import com.SEII.models.Post;

public class MyCartshopItemPostPOJO {
    /*Lo que hacemos en este POJO es obtener la información de un post que necesitemos para mostar en el item del carrito,
    por ahora solo es el precio del post, debido a que solo crearemos esta clase en situaciones muy particulares,
    el constructor lo dejo de esa manera.*/
    private Integer price;

    public MyCartshopItemPostPOJO MyCartshopItemPostPOJO(Post post) {
        MyCartshopItemPostPOJO post2 = new MyCartshopItemPostPOJO();
        post2.setPrice(post.getPrice());
        return post2;
    }
    
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
