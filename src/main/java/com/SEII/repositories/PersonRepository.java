package com.SEII.repositories;

import java.util.Optional;

import com.SEII.models.PersonDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonDTO, Integer> {
	Optional<PersonDTO> findByUsername(String username);
	PersonDTO findByEmail(String email);
}