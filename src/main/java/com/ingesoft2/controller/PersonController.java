package com.ingesoft2.controller;

import java.util.List;

import com.ingesoft2.models.PersonDTO;
import com.ingesoft2.models.Role;
import com.ingesoft2.pojo.MyProfilePOJO;
import com.ingesoft2.pojo.RegisterUserPOJO;
import com.ingesoft2.services.PersonService;
import com.ingesoft2.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/person")
public class PersonController {

    private PersonService personService;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public PersonController( PersonService personService, RoleService roleService, PasswordEncoder passwordEncoder){
        this.personService = personService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/hello")
    public String hello() {return "Hello World";}

    @GetMapping("/list")
    public List<PersonDTO> getAllPersonDTOs() {
        return personService.findAllPeople();
    }

    @GetMapping("/profile")
    public MyProfilePOJO getPersonByEmail() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        MyProfilePOJO person = new MyProfilePOJO(); //Solo lo declaro para poder usar sus metodos
        
        return person.myProfilePOJO(personService.findByUsername(username));
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addPerson(@RequestBody RegisterUserPOJO user) {

        Role role = roleService.getById(1);
        if (user != null) {
            PersonDTO user2 = new PersonDTO();
            user2.setName(user.getName());
            user2.setUsername(user.getUsername());
            user2.setEmail(user.getEmail());
            user2.setPassword(passwordEncoder.encode(user.getPassword()));
            user2.setPhoto(user.getPhoto());
            user2.setLocation(user.getLocation());
            user2.setPaypalId(user.getPaypalId());


            user2.setRoleId(role);
            personService.insert(user2);
            return new ResponseEntity<>(HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



    @DeleteMapping("{id}")
    public String deletePerson(@PathVariable("id") Integer id) {


        if(id > 0) {
            if(personService.delete(id)) {
                return "Deleted the person.";
            } else {
                return "Cannot delete the person.";
            }
        }
        return "The id is invalid for the person.";
    }

    @PutMapping("/update")
    public String updatePerson(@RequestBody PersonDTO person) {

        if(person != null) {
            personService.update(person);
            return "Updated person.";
        } else {
            return "Request does not contain a body";
        }
    }
}