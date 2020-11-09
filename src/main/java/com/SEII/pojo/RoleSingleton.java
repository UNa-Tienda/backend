package com.SEII.pojo;

import java.util.List;

import com.SEII.models.Role;

public class RoleSingleton {
  private static RoleSingleton uniqueInstance;
  private List<Role> roles;

  
  private RoleSingleton(List<Role> roles){
    this.roles = roles;
  }

  public static RoleSingleton getInstance(List<Role> roles){
    if(uniqueInstance == null){
      uniqueInstance = new RoleSingleton(roles);
    }

    return uniqueInstance;
  }


  public List<Role> getRoles() {
    return this.roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

}


