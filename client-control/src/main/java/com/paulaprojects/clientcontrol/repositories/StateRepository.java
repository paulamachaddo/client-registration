package com.paulaprojects.clientcontrol.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulaprojects.clientcontrol.entities.State;

public interface StateRepository extends JpaRepository<State, Long>{

	Optional<State> findById(UUID id);

	void deleteById(UUID id);

	State getReferenceById(UUID id);
	
}
