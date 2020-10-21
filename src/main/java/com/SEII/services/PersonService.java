package com.SEII.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SEII.models.Person;
import com.SEII.repositories.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    PersonRepository personRepository;

    public List<Person> findAllPeople() {
        return personRepository.findAll();
    }

    public Optional<Person> findByUsername(String username){
        return personRepository.findByUsername(username);
    }

    public Person insert(Person p) {
    	
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

    public Person findById(Integer id) {
        Optional<Person> result = personRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    public Person findByemail(String email) {
        return personRepository.findByEmail(email);
        }
    

    public boolean update(Person p) {
        try {
            personRepository.save(p);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
