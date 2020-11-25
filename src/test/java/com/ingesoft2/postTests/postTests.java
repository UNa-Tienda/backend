package com.ingesoft2.postTests;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.ingesoft2.models.PersonDTO;
import com.ingesoft2.models.Post;
import com.ingesoft2.models.Transaction;
import com.ingesoft2.services.PersonService;
import com.ingesoft2.services.PostService;
import com.ingesoft2.services.RoleService;
import com.ingesoft2.services.TransactionService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class postTests {
  
  @Autowired
  PersonService personService;

  @Autowired
  PostService postService;

  @Autowired
  RoleService roleService;

  @Autowired
  TransactionService transactionService;

@Test
void deleteNonExistentPost(){
  assertEquals(false, postService.delete(500));
}

@Test
void deleteExistentPostWithTransaction(){
  
  Post post = new Post();
  PersonDTO person = new PersonDTO();
  Transaction transaction = new Transaction();


  person.setRoleId(roleService.findById(1));
  person.setName("pruebaECT");
  person.setUsername("pruebaECT");
  person.setEmail("pruebaECT");
  person.setPassword("pruebaECT");
  person.setPaypalId("pruebaECT");

  personService.insert(person);

  Integer personId = personService.findByUsername("pruebaECT").getId();

  post.setSellerId(person);
  post.setTitle("pruebaECT");
  post.setProductName("pruebaECT");
  post.setPrice(1);
  post.setStock(1);

  postService.insert(post);

  Integer postId = postService.getPostsByPerson(person).get(0).getId();

  transaction.setBuyerPerson(person);
  transaction.setPostId(post);
  transaction.setStockPrice(1);
  transaction.setQuantity(1);

  transactionService.insert(transaction);
  /*La función de busqueda en el servicio retorna un arreglo, por eso doy el indice, y debido a que acabamos de crear
  todos los datos, la lista es de tamaño 1 y por lo tanto la info que necesitamos siempre esta en el indice 0*/
  Integer transactionId = transactionService.findByPerson(person).get(0).getId();

  assertEquals(false, postService.delete(postId));

  //Borro lo que agregue a la base de datos y no se borro antes
  transactionService.delete(transactionId);
  postService.delete(postId);
  personService.delete(personId);

}

@Test
void deleteExistentPost(){
  Post post = new Post();
  PersonDTO person = new PersonDTO();

  person.setRoleId(roleService.findById(1));
  person.setName("pruebaEE");
  person.setUsername("pruebaEE");
  person.setEmail("pruebaEE");
  person.setPassword("pruebaEE");
  person.setPaypalId("pruebaEE");

  personService.insert(person);

  Integer personId = personService.findByUsername("pruebaEE").getId();

  post.setSellerId(person);
  post.setTitle("pruebaEE");
  post.setProductName("pruebaEE");
  post.setPrice(1);
  post.setStock(1);

  postService.insert(post);
/*La función de busqueda en el servicio retorna un arreglo, por eso doy el indice, y debido a que acabamos de crear
  todos los datos, la lista es de tamaño 1 y por lo tanto la info que necesitamos siempre esta en el indice 0*/
  Integer postId = postService.getPostsByPerson(person).get(0).getId();

  assertEquals(true, postService.delete(postId));
  //Borro lo que agregue a la base de datos y que no se borro antes
  personService.delete(personId);
  
  
    
}

@Test
void thisIsMyPost(){
  Post post = new Post();
  PersonDTO person = new PersonDTO();

  post = postService.getByID(1);
  person = personService.findById(postService.getByID(1).getSellerId().getId());

  assertEquals(post.getSellerId().getId(), person.getId());
    
}

}

//Para elimnar, crear items y un post, usar la función de controller y comprobar que se hayan borrado los items y que el post se haya eliminado
//para mine, crear persona, asignarle un post, usar la función y comprobar la respuesta, hacer lo mismo con una persona que no sea dueña del post