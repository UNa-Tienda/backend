package com.SEII.pojo;

import java.util.ArrayList;
import java.util.List;

import com.SEII.models.Cartshop_item;

public class MyCartshopItemPOJO {
    /*Lo que hacemos en este POJO es guardae toda la información necesaria que se pidio en el front para luego devolverla, notese
    que esta clase usa al POJO  MyCartshopItemPostPOJO, el caso del constructor es lo mismo que el POJO Mycartshoppost, y pues con solo
    ingresarle la lista que ya retornaba Juan Pablo, me crea la lista nueva con todos los datos <3*/
    private MyCartshopItemPostPOJO cartshop_item_post;
    private Integer quantity ;

    public List<MyCartshopItemPOJO> MyCartshopItemPOJO(List<Cartshop_item> cartShopItems) {

        List<MyCartshopItemPOJO> cartShopItems2= new ArrayList<>();
        MyCartshopItemPostPOJO cartShopItemsPost = new MyCartshopItemPostPOJO() ;
        for(int i = 0; i < cartShopItems.size();i++){

            cartShopItems2.add( new MyCartshopItemPOJO() );

        }
        for(int i = 0; i < cartShopItems.size();i++){

            cartShopItems2.get(i).setQuantity(cartShopItems.get(i).getQuantity());;
            cartShopItems2.get(i).setCartshop_item_post(cartShopItemsPost.MyCartshopItemPostPOJO(cartShopItems.get(i).getCartshop_item_post_id()));
            /*Este ultimo atributo pude haberlo dejado como price y ya esta, pero como no se si en el futuro queramos
            sacar mas información del post, entonces lo dejo como una clase.*/
        }

        return cartShopItems2;


    }

    public MyCartshopItemPostPOJO getCartshop_item_post() {
        return cartshop_item_post;
    }

    public void setCartshop_item_post(MyCartshopItemPostPOJO cartshop_item_post) {
        this.cartshop_item_post = cartshop_item_post;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
    
}
