package com.SEII.controller;

import java.util.List;

import com.SEII.models.Category;
import com.SEII.models.Role;
import com.SEII.services.CategoryService;
import com.SEII.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/category")
public class CategoryController {
  
  @Autowired
  CategoryService categoryService;

  @GetMapping(value = {"/categories"})
  public List<Category> gRoles(){
    return categoryService.getCategories();
  }
}