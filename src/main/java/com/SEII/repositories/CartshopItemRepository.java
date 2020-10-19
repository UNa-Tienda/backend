package com.SEII.repositories;

import com.SEII.models.Cartshop_item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartshopItemRepository extends JpaRepository<Cartshop_item, Integer>{
  
}
