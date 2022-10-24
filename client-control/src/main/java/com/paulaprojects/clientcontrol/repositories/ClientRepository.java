package com.paulaprojects.clientcontrol.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulaprojects.clientcontrol.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	Optional<Client> findById(UUID id);

	void deleteById(UUID id);

	Client getReferenceById(UUID id);

}
