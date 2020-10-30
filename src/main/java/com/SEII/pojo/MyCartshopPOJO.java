package com.SEII.pojo;

public class MyCartshopPOJO {

    /*Lo que hacemos en este POJO es recibir el email(o id cuando este implementado el token) 
    que se usara para ubicar al usuario y posteriormente su carrito*/
    private String email;

    public MyCartshopPOJO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
