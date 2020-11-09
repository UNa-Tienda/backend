package com.SEII.services;

import java.util.List;
import java.util.Optional;

import com.SEII.models.Cartshop_item;
import com.SEII.models.PersonDTO;
import com.SEII.repositories.CartshopItemRepository;

import org.springframework.stereotype.Service;

@Service
public class CartshopItemService {
  
  private final CartshopItemRepository cartshopItemRepository;


  public CartshopItemService(CartshopItemRepository cartshopItemRepository) {
    this.cartshopItemRepository = cartshopItemRepository;
  }

  public Cartshop_item insert(Cartshop_item p) {

    try
    {
      return cartshopItemRepository.save(p);
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
      return p;
    }

  }


  public List<Cartshop_item> getItems(){
    return cartshopItemRepository.findAll();
  }

  public List<Cartshop_item> findByCartshop(int cartshopId){
    return cartshopItemRepository.findByCartshop_Id(cartshopId);
  }

  public Cartshop_item getByID (Integer id){
      Optional<Cartshop_item> result = cartshopItemRepository.findById(id);
    if (result.isPresent()) {
      return result.get();
    } else {
      return null;
    }
  }

  public boolean delete(Integer id) {
    try {
      cartshopItemRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  public boolean update(Cartshop_item p) {
    try {
      cartshopItemRepository.save(p);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
}
