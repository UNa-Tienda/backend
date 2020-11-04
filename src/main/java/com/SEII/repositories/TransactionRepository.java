package com.SEII.repositories;

import java.util.List;

import com.SEII.models.PersonDTO;
import com.SEII.models.Transaction;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
  
  @Query("FROM transaction WHERE buyerPerson = ?person")
  List<Transaction> findByBuyerPerson(PersonDTO person);
}
