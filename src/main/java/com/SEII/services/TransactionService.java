package com.SEII.services;

import java.util.List;

import com.SEII.models.PersonDTO;
import com.SEII.models.Transaction;
import com.SEII.repositories.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
  
  private TransactionRepository transactionRepository;

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
