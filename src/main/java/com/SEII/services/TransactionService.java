package com.SEII.services;

import java.util.List;

import com.SEII.models.Transaction;
import com.SEII.repositories.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
  
  @Autowired
  TransactionRepository transactionRepository;

  public List<Transaction> getTransactions(){
    return transactionRepository.findAll();
  }
}
