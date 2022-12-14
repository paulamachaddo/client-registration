package com.paulaprojects.clientcontrol.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulaprojects.clientcontrol.entities.City;

public interface CityRepository extends JpaRepository<City, Long>{

	Optional<City> findById(UUID id);

	void deleteById(UUID id);

	City getReferenceById(UUID id);

	
}
