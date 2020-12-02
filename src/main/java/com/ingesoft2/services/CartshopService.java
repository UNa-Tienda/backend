package com.ingesoft2.services;

import java.util.List;

import com.ingesoft2.models.Cartshop;
import com.ingesoft2.models.PersonDTO;
import com.ingesoft2.repositories.CartshopRepository;

import org.springframework.stereotype.Service;

@Service
public class CartshopService {
  
  private final CartshopRepository cartshopRepository;


  public CartshopService(CartshopRepository cartshopRepository) {
    this.cartshopRepository = cartshopRepository;
  }
  
  public Cartshop insert(Cartshop c) {
  	
  	try 
  	{
  		return cartshopRepository.save(c);
  	}
  	catch(Exception e) 
  	{
          
  		/*Implementar logging sobre el insert de un person*/
  		return c;
  	}
      
  }


  public List<Cartshop> getCartshops(){
    return cartshopRepository.findAll();
  }

  public Cartshop findById(int id) {
    return cartshopRepository.findById(id);
  }

  public Cartshop findByPersonId(int pid){return  cartshopRepository.findByPersonCartshopId(pid);}
}
