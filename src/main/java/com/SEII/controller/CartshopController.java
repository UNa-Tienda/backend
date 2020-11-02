package com.SEII.controller;

import com.SEII.models.Cartshop;
import com.SEII.models.Cartshop_item;
import com.SEII.models.Category;
import com.SEII.models.PersonDTO;
import com.SEII.pojo.MyCartshopItemPOJO;
import com.SEII.services.CartshopItemService;
import com.SEII.services.CartshopService;
import com.SEII.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/shopping_cart")
public class CartshopController {

  @Autowired
  PersonService peopleService;

  @Autowired
  CartshopService cartshopService;

  @Autowired
  CartshopItemService cartshopItemService;


  @GetMapping(value = {"/items"})
  public List<MyCartshopItemPOJO>  getItems(){
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    PersonDTO person2 = peopleService.findByUsername(username);
    //Esta parte no require Pojos ya que no es información que entra o sale del back
    Cartshop cartshop = cartshopService.findByPersonId(person2.getId()); /*Falta controlar el caso en el que un usuario no tenga carrito
    O hacer que siempre que se crean tengan carrito (seria lo ideal) entonces mas que nada hay que controlar cuando tengan 0 items en el carrito*/
    MyCartshopItemPOJO myCartShopItems = new MyCartshopItemPOJO();
    //Creo este objeto sencillamente para usar el metodo que luego me retorna la lista.
    

    //List<Cartshop_item> items =
    return myCartShopItems.MyCartshopItemPOJO(cartshopItemService.findByCartshop(cartshop.getId()));
  }
}