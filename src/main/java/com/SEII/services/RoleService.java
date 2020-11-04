package com.SEII.services;

import java.util.List;
import java.util.Optional;

import com.SEII.models.Role;
import com.SEII.repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

  private final RoleRepository roleRepository;


  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }


  public List<Role> getAllRoles() {
    return roleRepository.findAll();
  }

  public Role getById(Integer id) {
    List<Role> roles = getAllRoles();

    Role role = roles.get(0);
    return role;
  }
}
