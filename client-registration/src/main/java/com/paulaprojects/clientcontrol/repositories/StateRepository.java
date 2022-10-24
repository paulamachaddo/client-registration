package com.paulaprojects.clientregistration.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulaprojects.clientregistration.entities.State;

public interface StateRepository extends JpaRepository<State, Long>{

	Optional<State> findById(UUID id);

	void deleteById(UUID id);

	State getReferenceById(UUID id);

}
