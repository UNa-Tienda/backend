package com.SEII.controller;

import com.SEII.models.Cartshop;
import com.SEII.models.Cartshop_item;
import com.SEII.models.Category;
import com.SEII.models.Person;
import com.SEII.services.CartshopItemService;
import com.SEII.services.CartshopService;
import com.SEII.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping(value = {"/shopping_cart"})
  public List<Cartshop_item>  getItems(){
    // cambiar despues con auth
    Cartshop cartshop = cartshopService.findById(1);
    //List<Cartshop_item> items =
    return cartshopItemService.findByCartshop(cartshop.getId());
  }
}