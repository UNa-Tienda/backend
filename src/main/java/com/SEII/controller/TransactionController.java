package com.SEII.controller;

import java.util.List;

import com.SEII.models.PersonDTO;
import com.SEII.models.Transaction;
import com.SEII.services.PersonService;
import com.SEII.services.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/transactions")
public class TransactionController {
  
  private TransactionService transactionService;
  private PersonService personService;

  @Autowired
  public TransactionController(TransactionService transactionService, PersonService personService){
    this.transactionService = transactionService;
    this.personService = personService;
  }
  
  @GetMapping(value = {"/all"})
  public List<Transaction> getAllTransactions(){
    return transactionService.getTransactions();
  }

  @GetMapping(value = {"/my-transactions"})
  public List<Transaction> getTransactionsByPerson(){
    String username = SecurityContextHolder.getContext( ).getAuthentication( ).getName( );
    PersonDTO person = personService.findByUsername(username);
    if(person == null){
      return null;
    }else{
      List<Transaction> transactions = transactionService.findByPerson(person);
      return transactions;
    }
  }
  
}
