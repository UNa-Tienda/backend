package com.SEII.controller;

import java.util.List;

import com.SEII.entity.Post;
import com.SEII.services.PostService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
  
  private PostService postService;

  public PostController( PostService postService){
    this.postService = postService;
  }

  @GetMapping( value = {"/posts"})
  public List<Post> getAllPosts(){
    return postService.getAllPosts();
  }
}
