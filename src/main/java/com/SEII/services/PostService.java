package com.SEII.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SEII.models.PersonDTO;
import com.SEII.models.Post;
import com.SEII.repositories.PostRepository;


@Service
public class PostService {
    
    
    private final PostRepository postRepository;


    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Post> getPostsByPerson(PersonDTO person){
        return postRepository.findBySellerId(person);
    }

    public List<Post> getAllPosts() {
        return (List<Post>)postRepository.findAll();
    }

    public Post insert(Post p) {
    	
    	try 
    	{
    		return postRepository.save(p);
    	}
    	catch(Exception e) 
    	{
    		System.out.println(e.getMessage());
    		return p;
    	}
        
    }

    public boolean delete(Integer id) {
        try {
            postRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Post findById(Integer id) {
        Optional<Post> result = postRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    public boolean update(Post p) {
        try {
            postRepository.save(p);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
