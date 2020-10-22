package com.SEII.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SEII.models.PersonDTO;
import com.SEII.repositories.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    PersonRepository personRepository;

    public List<PersonDTO> findAllPeople() {
        return personRepository.findAll();
    }

    public Optional<PersonDTO> findByUsername(String username){
        return personRepository.findByUsername(username);
    }

    public PersonDTO insert(PersonDTO p) {
    	
    	try 
    	{
    		return personRepository.save(p);
    	}
    	catch(Exception e) 
    	{
    		System.out.println(e.getMessage());
    		return p;
    	}
        
    }

    public boolean delete(Integer id) {
        try {
            personRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public PersonDTO findById(Integer id) {
        Optional<PersonDTO> result = personRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    public PersonDTO findByemail(String email) {
        return personRepository.findByEmail(email);
        }
    

    public boolean update(PersonDTO p) {
        try {
            personRepository.save(p);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
