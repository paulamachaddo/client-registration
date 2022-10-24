package com.paulaprojects.clientcontrol.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.paulaprojects.clientcontrol.entities.City;
import com.paulaprojects.clientcontrol.exceptions.ResourceNotFoundException;
import com.paulaprojects.clientcontrol.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	public Page<City> findAll(Pageable pageable){
		return cityRepository.findAll(pageable);
	}
	
//	Método para encontrar a cidade pelo id, e caso ela não exista lança uma exceção com status 404 com mensagem adaptada.
	
	public City findById(UUID id) {
		Optional<City> city = cityRepository.findById(id);
		return city.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public City save(City city) {
		return cityRepository.save(city);
	}
	
	public void delete(UUID id) {
		cityRepository.deleteById(id);;
	}
	
	public void updateData (City entity, City obj) {
		entity.setName(obj.getName());
		entity.setState(obj.getState());
	}
	
	public City update(UUID id, City city) {
		City entity = cityRepository.getReferenceById(id);
		updateData(entity, city);
		return cityRepository.save(entity);
	}
}
