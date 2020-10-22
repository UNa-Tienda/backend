package com.SEII.controller;

import java.util.List;
import java.util.Optional;

import com.SEII.models.PersonDTO;
import com.SEII.models.Role;
import com.SEII.services.PersonService;
import com.SEII.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/people")
public class PeopleApiController {

    @Autowired
    PersonService peopleService;

    @Autowired
    RoleService roleService;

    @GetMapping("/list")
    public List<PersonDTO> getAllPeople() {
        return peopleService.findAllPeople();
    }

    @GetMapping("{email}")
    public PersonDTO getPersonByEmail(@PathVariable String email) {
        return peopleService.findByemail(email);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addPerson(@RequestBody PersonDTO person){
    //public String addPerson(@RequestBody Person person) {

        Role role = roleService.getById(1);
        if(person != null) {
            System.out.println(person.toString());
            person.setRole_id(role);
            peopleService.insert(person);
            //return "Added a person";
            return new ResponseEntity<>( HttpStatus.CREATED );
        } else {
            //return "Request does not contain a body";
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody PersonDTO person ) {
        PersonDTO person2 = peopleService.findByemail(person.getEmail());
        if(person2 != null) {
            if(person2.getPassword().equals(person.getPassword())){
                return new ResponseEntity<>( HttpStatus.OK );
            }else{
                return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
            }        
        } else {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }

         
    }

	@DeleteMapping("{id}")
    public String deletePerson(@PathVariable("id") Integer id) {

        if(id > 0) {
            if(peopleService.delete(id)) {
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
            peopleService.update(person);
            return "Updated person.";
        } else {
            return "Request does not contain a body";
        }
    }
}