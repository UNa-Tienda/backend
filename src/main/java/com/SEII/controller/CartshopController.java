package com.SEII.controller;

import com.SEII.models.Cartshop;
import com.SEII.models.Cartshop_item;
import com.SEII.models.Category;
import com.SEII.models.PersonDTO;
import com.SEII.pojo.MyCartshopItemPOJO;
import com.SEII.pojo.MyCartshopPOJO;
import com.SEII.services.CartshopItemService;
import com.SEII.services.CartshopService;
import com.SEII.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartshopController {

  @Autowired
  PersonService peopleService;
  
  @Autowired
  CartshopService cartshopService;

  @Autowired
  CartshopItemService cartshopItemService;

  @PostMapping(value = {"/shopping_cart"})
  public List<MyCartshopItemPOJO>  getItems(@RequestBody MyCartshopPOJO person){
    // cambiar despues con auth
    PersonDTO person2 = peopleService.findByemail(person.getEmail()); 
    //Esta parte no require Pojos ya que no es información que entra o sale del back
    Cartshop cartshop = cartshopService.findByPersonId(person2.getId());

    MyCartshopItemPOJO myCartShopItems = new MyCartshopItemPOJO();
    //Creo este objeto sencillamente para usar el metodo que luego me retorna la lista.
    
    //List<Cartshop_item> items =
    return myCartShopItems.MyCartshopItemPOJO(cartshopItemService.findByCartshop(cartshop.getId()));
  }
}