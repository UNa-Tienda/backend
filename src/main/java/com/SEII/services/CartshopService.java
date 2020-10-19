package com.SEII.services;

import java.util.List;

import com.SEII.models.Cartshop;
import com.SEII.repositories.CartshopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartshopService {
  
  @Autowired
  CartshopRepository cartshopRepository;

  public List<Cartshop> getCartshops(){
    return cartshopRepository.findAll();
  }
}
