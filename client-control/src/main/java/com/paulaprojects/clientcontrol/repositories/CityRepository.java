package com.paulaprojects.clientcontrol.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.paulaprojects.clientcontrol.entities.City;
import com.paulaprojects.clientcontrol.entities.State;

public interface CityRepository extends JpaRepository<City, Long>, PagingAndSortingRepository<City, Long>{

	Optional<City> findById(UUID id);

	void deleteById(UUID id);

	City getReferenceById(UUID id);

	
}
