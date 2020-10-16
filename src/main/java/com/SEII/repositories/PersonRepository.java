package com.SEII.repositories;

import java.util.Optional;

import com.SEII.models.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	Optional<Person> findByUsername(String username);
}