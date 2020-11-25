package com.ingesoft2.services;

import java.util.List;

import com.ingesoft2.models.PersonDTO;
import com.ingesoft2.models.Transaction;
import com.ingesoft2.repositories.TransactionRepository;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {
  
  private TransactionRepository transactionRepository;

  public Transaction insert(Transaction t) {
    	
    try 
    {
      return transactionRepository.save(t);
    }
    catch(Exception e) 
    {
      return t;
    }
      
  }

  public boolean delete(Integer id) {
      try {
          transactionRepository.deleteById(id);
          return true;
      } catch (Exception e) {

          return false;
      }
  }

  public TransactionService(TransactionRepository transactionRepository){
    this.transactionRepository = transactionRepository;
  }

  public List<Transaction> getTransactions(){
    return transactionRepository.findAll();
  }

  public List<Transaction> findByPerson(PersonDTO person){
    return transactionRepository.findByBuyerPerson(person);
}
}
