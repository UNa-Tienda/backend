package com.SEII.repositories;

import org.springframework.stereotype.Repository;

import com.SEII.models.Post;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
