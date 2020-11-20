package com.ingesoft2.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ingesoft2.models.CartshopItem;
import com.ingesoft2.models.Category;
import com.ingesoft2.models.PersonDTO;
import com.ingesoft2.models.Post;
import com.ingesoft2.pojo.CreatePostPOJO;
import com.ingesoft2.services.CartshopItemService;
import com.ingesoft2.services.CategoryService;
import com.ingesoft2.services.PersonService;
import com.ingesoft2.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/post")
public class PostController {

    private PersonService personService;
    private PostService postService;
    private CategoryService categoryService;
    private CartshopItemService cartshopItemService;

    @Autowired
    public PostController(PersonService personService, PostService postService, CategoryService categoryService, CartshopItemService cartshopItemService){
        this.personService = personService;
        this.postService = postService;
        this.categoryService = categoryService;
        this.cartshopItemService = cartshopItemService;
    }


    @GetMapping("/list")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping(value = { "/my-posts" })
    public List<Post> getPostByPerson() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        PersonDTO person = personService.findByUsername(username);
        if(person == null){
            return Collections.emptyList();
        }else{
            return postService.getPostsByPerson(person);
        }
    }

    @GetMapping("{id}")
    public Post getPost(@PathVariable Integer id) {
        return postService.getByID(id);
    }

    @PostMapping("/add/{categoryId}") /*
                                       * Aqui tocaria ver como se saca la informaciòn del token para poner la ID en
                                       * lugar de ese "1" que esta fijo
                                       */
    public ResponseEntity<Void> addPost(@PathVariable Integer categoryId, @RequestBody CreatePostPOJO post) {

        if (post != null) {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            PersonDTO person = personService.findByUsername(username);
            Category category = categoryService.getCategory(categoryId);
            if (person == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Post post2 = new Post();
            post2.setTitle(post.getTitle());
            post2.setProductName(post.getProductName());
            post2.setImage(post.getImage());
            post2.setDescription(post.getDescription());
            post2.setPrice(post.getPrice());
            post2.setStock(post.getStock());
            

            post2.setSellerId(person);
            post2.setCategoryId(category);
            postService.insert(post2);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Integer id) {
        //Primero me encargo de los items asociados que se eliminan si o si sin importar las transacciones del post
        List<CartshopItem> items = new ArrayList<>();
        items = cartshopItemService.getItems();
        for(int i = 0; i < items.size();i++){
            if(items.get(i).getCartshopItemPostId().getId().equals(id)){
                cartshopItemService.delete(items.get(i).getId()); /*Hago la busqueda de esta manera 
                ya que la id no tiene por que ser igual a la posición*/
            }
        }
        //Luego trato de eliminar el post, y en caso de no poderse, cambio su estado

        if (id > 0) {
            //Caso cuando el post no tiene transacciones asociadas
            if (postService.delete(id)) {
                return new ResponseEntity<>(HttpStatus.OK);
            //Caso cuando el post tiene transacciones asociadas
            } else {
                Post post2 = postService.getByID(id);
                post2.setState(false);//Cambios el estado del post ya que las relaciones impiden borrarlo
                postService.update(post2); //Actualizo
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public PostController(PostService postService) {
        this.postService = postService;
    }

}
