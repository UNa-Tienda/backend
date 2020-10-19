package com.SEII.repositories;

import java.util.Optional;

import com.SEII.models.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	Optional<Person> findByUsername(String username);
}