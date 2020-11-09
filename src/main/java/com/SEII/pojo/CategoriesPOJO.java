package com.SEII.pojo;

import java.util.ArrayList;
import java.util.List;

import com.SEII.models.Category;

public class CategoriesPOJO {
  private Integer id; 
  private String name;

  public List<CategoriesPOJO> categoriesPOJO(List<Category> categorias) {
      //Lo pongo a recibir una lista ya que de momento el controlador que lo llama requiere una lista como objetos de salida de la función
      List<CategoriesPOJO> categorias2 = new ArrayList<>();
      for(int i = 0; i < categorias.size();i++){

          categorias2.add( new CategoriesPOJO() );

      }
      for(int i = 0; i < categorias.size();i++){

          categorias2.get(i).setId(categorias.get(i).getId());
          categorias2.get(i).setName(categorias.get(i).getName());
      }
      return categorias2;
    }

  public Integer getId() {
      return id;
  }

  public void setId(Integer id) {
      this.id = id;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }
}

