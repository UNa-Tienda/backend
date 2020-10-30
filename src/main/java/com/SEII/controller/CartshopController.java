package com.SEII.controller;

import com.SEII.models.Cartshop;
import com.SEII.models.Cartshop_item;
import com.SEII.models.Category;
import com.SEII.models.PersonDTO;
import com.SEII.services.CartshopItemService;
import com.SEII.services.CartshopService;
import com.SEII.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/shopping_cart")
public class CartshopController {

  @Autowired
  PersonService peopleService;

  @Autowired
  CartshopService cartshopService;

  @Autowired
  CartshopItemService cartshopItemService;

  @PostMapping(value = {"/items"})
  public List<Cartshop_item>  getItems(@RequestBody PersonDTO sperson){
    // cambiar despues con auth
    PersonDTO person = peopleService.findByEmail(sperson.getEmail());
    Cartshop cartshop = cartshopService.findByPersonId(person.getId());
    //List<Cartshop_item> items =
    return cartshopItemService.findByCartshop(cartshop.getId());
  }
}