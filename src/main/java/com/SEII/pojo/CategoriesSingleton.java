package com.SEII.pojo;

import java.util.List;


import com.SEII.models.Category;
import com.SEII.services.CategoryService;

public class CategoriesSingleton {
    private static CategoriesSingleton uniqueInstance;
    private List<Category> categories;

    private CategoriesSingleton(List<Category> categories2){

        for(int i = 0; i < categories2.size();i++){
            this.categories.add( categories2.get(i) );
        }
    }

    public static CategoriesSingleton getInstance(List<Category> categories2){
        if(uniqueInstance == null){
            uniqueInstance = new CategoriesSingleton(categories2);
        }
        return uniqueInstance;
    }

    

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public static CategoriesSingleton getUniqueInstance() {
        return uniqueInstance;
    }

    public static void setUniqueInstance(CategoriesSingleton uniqueInstance) {
        CategoriesSingleton.uniqueInstance = uniqueInstance;
    }



}
