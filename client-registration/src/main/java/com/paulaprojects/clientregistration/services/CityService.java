package com.paulaprojects.clientregistration.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulaprojects.clientregistration.entities.City;
import com.paulaprojects.clientregistration.exceptions.ResourceNotFoundException;
import com.paulaprojects.clientregistration.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	public List<City> findAll(){
		return cityRepository.findAll();
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
