package com.SEII.services;

import java.util.List;

import com.SEII.models.Category;
import com.SEII.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
  
  @Autowired
  CategoryRepository categoryRepository;

  public List<Category> getCategories(){
    return categoryRepository.findAll();
  }

  public Category getCategory(Integer id){
    return categoryRepository.getOne(id);
  }
}