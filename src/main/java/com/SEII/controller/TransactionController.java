package com.SEII.controller;

import java.util.ArrayList;
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

  @GetMapping(value = {"/my-seller-transactions"})
  public List<Transaction> getMySellerHistorial(){
    String username = SecurityContextHolder.getContext( ).getAuthentication( ).getName( );
    Integer myId = personService.findByUsername(username).getId();//Con el id ubicare todas las transacciones como vendedor de esa persona
    List<Transaction> allTransactions = transactionService.getTransactions();
    List<Transaction> MyTransactions = new ArrayList<>();
    Transaction transaction = new Transaction();
    /*Aqui inicializo todo lo que usare abajo, podria hacer las busquedas directamente 
    con el get de allTransaction, pero prefiero crear un objeto*/

    for(int i = 0; i < allTransactions.size();i++){
      /*En este for busco dentro de todas las transacciones su respectivos post, luego comparo la id
      de estos post con myId, si son iguales entonces es una de mis transacciones como vendedor 
      y se agrega a la lista que retorno */
      //Esto es super ineficiente pero por el momento lo dejo así D:
      transaction = allTransactions.get(i);
      if(transaction.getPost_id().getId() == myId){
        MyTransactions.add(transaction);
      }
    }
    return MyTransactions;
  }
  
}
