package com.SEII.services;

import java.util.List;

import com.SEII.models.Role;
import com.SEII.repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
  
  @Autowired
  RoleRepository roleRepository;

  public List<Role> getAllRoles(){
    return roleRepository.findAll();
  }
}
