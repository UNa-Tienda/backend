package com.SEII.repositories;

import com.SEII.models.Cartshop_item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartshopItemRepository extends JpaRepository<Cartshop_item, Integer>{
    List<Cartshop_item> findByCartshop_Id(int id);
  
}
//Comentario prueba