package com.SEII.controller;

import java.util.List;

import com.SEII.models.Category;
import com.SEII.models.Role;
import com.SEII.pojo.CategoriesPOJO;
import com.SEII.pojo.CategoriesSingleton;
import com.SEII.services.CategoryService;
import com.SEII.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/category")
public class CategoryController {
  
  private CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService){
    this.categoryService = categoryService;
  }

  @GetMapping(value = {"/categories"})
  public List<CategoriesPOJO> getCategories() {
    CategoriesPOJO categoriesPOJO = new CategoriesPOJO();//Solo creo el objeto para poder llamar la función
    return categoriesPOJO.categoriesPOJO(CategoriesSingleton.getInstance(categoryService.getCategories()).getCategories());
  }
}