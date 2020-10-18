package com.SEII.services;

import java.util.List;

import com.SEII.models.Post;
import com.SEII.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
  
  @Autowired
  PostRepository postRepository;

  public List<Post> getAllPosts(){
    return postRepository.findAll();
  }
}
