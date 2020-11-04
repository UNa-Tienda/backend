package com.SEII.services;

import java.util.List;

import com.SEII.models.Cartshop_item;
import com.SEII.repositories.CartshopItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartshopItemService {
  
  private final CartshopItemRepository cartshopItemRepository;


  public CartshopItemService(CartshopItemRepository cartshopItemRepository) {
    this.cartshopItemRepository = cartshopItemRepository;
  }


  public List<Cartshop_item> getItems(){
    return cartshopItemRepository.findAll();
  }
  public List<Cartshop_item> findByCartshop(int cartshopId){
    return cartshopItemRepository.findByCartshop_Id(cartshopId);
  }
}
