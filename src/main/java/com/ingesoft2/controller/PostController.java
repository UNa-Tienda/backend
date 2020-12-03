package com.ingesoft2.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import com.ingesoft2.models.CartshopItem;
import com.ingesoft2.models.Category;
import com.ingesoft2.models.PersonDTO;
import com.ingesoft2.models.Post;
import com.ingesoft2.pojo.CreatePostPOJO;
import com.ingesoft2.pojo.UpdatePostPOJO;
import com.ingesoft2.services.CartshopItemService;
import com.ingesoft2.services.CategoryService;
import com.ingesoft2.services.PersonService;
import com.ingesoft2.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;


@RestController()
@RequestMapping("/api/post")
public class PostController {

    private PersonService personService;
    private PostService postService;
    private CategoryService categoryService;
    private CartshopItemService cartshopItemService;
    public String imageLink;

    @Autowired
    public PostController(PersonService personService, PostService postService, CategoryService categoryService, CartshopItemService cartshopItemService){
        this.personService = personService;
        this.postService = postService;
        this.categoryService = categoryService;
        this.cartshopItemService = cartshopItemService;
        imageLink = "";
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


    @PostMapping("/add-image")
    public void createNewObjectWithImage(@RequestParam(value = "file", required = true) MultipartFile file)
            throws IOException {

        String api = "https://api.imgur.com/3/upload";        
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Client-ID 79ae804643cffff");//Datos para acceder a la API
            headers.set("Content-Disposition", "form-data;");
            
            String filename = file.getOriginalFilename();

            ByteArrayResource contentAsResource = new ByteArrayResource(file.getBytes()){
                @Override
                public String getFilename(){
                    return filename;
                }
            };
            //Aqui ya quedo la infor dentro de res
            //Ahora preparamos la petición a la API de imgur
            MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();
            formData.add("image", contentAsResource);
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(formData, headers);

            //Esta es la respuesta de la petición
            ResponseEntity<String> result = restTemplate.exchange(api, HttpMethod.POST,requestEntity,String.class);

            //Y aqui separo el link de toda la respuesta
            String link = result.getBody();
            int inicio = link.indexOf("https");
            int fin = link.lastIndexOf("png"); //Si la imagen no es png podriamos tener problemas D:
            link = link.substring(inicio, fin+3);
            this.imageLink = link;
    }
        
       
    

    @PostMapping("/add/{categoryId}") /*
                                       * Aqui tocaria ver como se saca la informaciòn del token para poner la ID en
                                       * lugar de ese "1" que esta fijo
                                       */
    public ResponseEntity<Void> addPost(@PathVariable Integer categoryId, @RequestBody CreatePostPOJO post)
            throws IOException {

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
            post2.setDescription(post.getDescription());
            post2.setPrice(post.getPrice());
            post2.setStock(post.getStock());
            

            post2.setSellerId(person);
            post2.setCategoryId(category);
            post2.setImage(this.imageLink);
            postService.insert(post2);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Integer id) {
        //Primero me encargo de los items asociados que se eliminan si o si sin importar las transacciones del post
        List<CartshopItem> items = cartshopItemService.getItems();
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
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/mine/{id}") 
    public ResponseEntity<Void> isItMine(@PathVariable("id") Integer id) {
        Post post = postService.getByID(id);
        /*Aqui sencillamente hago una comprobación de si la persona que trata de borrar el post, es la persona que creo el post
        si se envia la respuesta Accepted (202), el usuario y el creador son la misma persona, de lo contrario,
        son personas distintas */
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer userId = personService.findByUsername(username).getId();
        if(userId.equals(post.getSellerId().getId())){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    public PostController(PostService postService) {
        this.postService = postService;
    }
    
    @PutMapping("/update")
    public ResponseEntity<Void> updatePerson(@RequestBody UpdatePostPOJO post) {
        Post post2 = postService.getByID(post.getId());
        post2.setProductName(post.getProductName());
        post2.setTitle(post.getTitle());
        post2.setDescription(post.getDescription());
        post2.setPrice(post.getPrice());
        post2.setStock(post.getStock());
        postService.update(post2);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
