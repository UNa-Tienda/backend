package com.SEII.controller;

import java.util.List;

import com.SEII.models.Category;
import com.SEII.models.Person;
import com.SEII.models.Post;
import com.SEII.services.CategoryService;
import com.SEII.services.PersonService;
import com.SEII.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {
  
  @Autowired
  private PersonService personService; 

  @Autowired
  private PostService postService;

  @Autowired
  private CategoryService categoryService;
  
  @GetMapping("/list")
  public List<Post> getAllPosts() {
      return postService.getAllPosts();
  }

  @GetMapping("{id}")
  public Post getPost(@PathVariable Integer id) {
      return postService.findById(id);
  }

  @PostMapping("/add") /*Aqui tocaria ver como se anexa el token al path, luego ese path se toma como parametro
  en la función addPost (@PathVariable String token) o algo así, con eso buscamos la info del usuario
  y sacamos su id, y ya con eso s ebusca la persona y se le anexa, pero de momento pondre la id manual  */
  public ResponseEntity<Void> addPost(@RequestBody Post post) {

      if(post != null) {
          Person person = personService.findById(1); // esto es lo que digo que toca cambiar pero de momento lo dejo con valores fijos
          Category category = categoryService.getCategory(1);
          if( person == null ){
              return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
          }
          
          post.setSeller_id(person);
          post.setCategory_id(category);
          post.setStock(10);
          System.out.print(post.toString());
          postService.insert(post);
          return new ResponseEntity<>( HttpStatus.CREATED );
      } else {
          return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
      }
  }


@DeleteMapping("{id}")
  public String deletePost(@PathVariable("id") Integer id) {

      if(id > 0) {
          if(postService.delete(id)) {
              return "Deleted the post.";
          } else {
              return "Cannot delete the post.";
          }
      }
      return "The id is invalid for the post.";
  }

  @PutMapping("/update")
  public String updatePerson(@RequestBody Post post) {
      if(post != null) {
          postService.update(post);
          return "Updated post.";
      } else {
          return "Request does not contain a body";
      }
  }

  public PostController( PostService postService){
    this.postService = postService;
  }


}
