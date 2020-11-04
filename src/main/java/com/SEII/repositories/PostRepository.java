package com.SEII.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.SEII.models.PersonDTO;
import com.SEII.models.Post;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

  @Query("FROM post WHERE seller_id = :person")
  List<Post> findBySellerId(PersonDTO person);
}

