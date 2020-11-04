package com.SEII.controller;

import java.util.List;

import com.SEII.models.Role;
import com.SEII.pojo.RolesPOJO;
import com.SEII.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/roles")
public class RoleController {
  
  private RoleService roleService;


  @Autowired
  public RoleController(RoleService roleService){
    this.roleService = roleService;
  }


  @GetMapping(value = {"/roles"})
  public List<RolesPOJO> gRoles(){
    RolesPOJO roles = new RolesPOJO();//Solo creo el objeto para poder llamar la función
    return roles.RolesPOJO(roleService.getAllRoles()); //Con esto se retorna la lista de roles POJO

}
}
