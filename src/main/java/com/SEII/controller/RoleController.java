package com.SEII.controller;

import java.util.List;

import com.SEII.models.Role;
import com.SEII.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
  
  @Autowired
  RoleService roleService;

  @GetMapping(value = {"/roles"})
  public List<Role> gRoles(){
    return roleService.getAllRoles();
  }
}
