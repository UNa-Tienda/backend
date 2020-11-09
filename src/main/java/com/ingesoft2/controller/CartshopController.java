package com.ingesoft2.controller;

import com.ingesoft2.models.Cartshop;
import com.ingesoft2.models.PersonDTO;
import com.ingesoft2.pojo.MyCartshopItemPOJO;
import com.ingesoft2.services.CartshopItemService;
import com.ingesoft2.services.CartshopService;
import com.ingesoft2.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/shopping-cart")
public class CartshopController {

  private PersonService personService;

  private CartshopService cartshopService;

  private CartshopItemService cartshopItemService;


  @Autowired
  public CartshopController(PersonService personService, CartshopService cartshopService, CartshopItemService cartshopItemService){
    this.personService = personService;
    this.cartshopService = cartshopService;
    this.cartshopItemService = cartshopItemService;
  }


  @GetMapping(value = {"/items"})
  public List<MyCartshopItemPOJO>  getItems(){
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    PersonDTO person2 = personService.findByUsername(username);
    //Esta parte no require Pojos ya que no es información que entra o sale del back
    Cartshop cartshop = cartshopService.findByPersonId(person2.getId()); /*Falta controlar el caso en el que un usuario no tenga carrito
    O hacer que siempre que se crean tengan carrito (seria lo ideal) entonces mas que nada hay que controlar cuando tengan 0 items en el carrito*/
    MyCartshopItemPOJO myCartShopItems = new MyCartshopItemPOJO();
    //Creo este objeto sencillamente para usar el metodo que luego me retorna la lista.

    //List<Cartshop_item> items =
    return myCartShopItems.myCartshopItemPOJO(cartshopItemService.findByCartshop(cartshop.getId()));
  }
}