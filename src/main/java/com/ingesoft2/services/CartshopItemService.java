package com.ingesoft2.services;

import java.util.List;

import com.ingesoft2.models.CartshopItem;
import com.ingesoft2.repositories.CartshopItemRepository;

import org.springframework.stereotype.Service;

@Service
public class CartshopItemService {
  
  private final CartshopItemRepository cartshopItemRepository;


  public CartshopItemService(CartshopItemRepository cartshopItemRepository) {
    this.cartshopItemRepository = cartshopItemRepository;
  }


  public List<CartshopItem> getItems(){
    return cartshopItemRepository.findAll();
  }
  public List<CartshopItem> findByCartshop(int cartshopId){
    return cartshopItemRepository.findByCartshopId(cartshopId);
  }
}
