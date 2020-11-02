package com.SEII.controller;

import java.util.List;

import com.SEII.models.Transaction;
import com.SEII.services.TransactionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/transactions")

public class TransactionController {
  
  private TransactionService transactionService;


  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @GetMapping(value = {"/all"})
  public List<Transaction> getAllTransactions(){
    return transactionService.getTransactions();
  }
  
}
