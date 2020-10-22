package com.SEII.repositories;

import com.SEII.models.Cartshop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartshopRepository extends JpaRepository<Cartshop, Integer>{

    Cartshop findById(int id);

    Cartshop findByPersonCartshop_Id(int pid);
}
