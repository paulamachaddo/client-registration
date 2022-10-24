package com.paulaprojects.clientregistration.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulaprojects.clientregistration.entities.State;
import com.paulaprojects.clientregistration.exceptions.ResourceNotFoundException;
import com.paulaprojects.clientregistration.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	public List<State> findAll() {
		return stateRepository.findAll();
	}

//	Método para encontrar o estado pelo id, e caso ele não exista lança uma exceção com status 404 com mensagem adaptada.

	public State findById(UUID id) {
		Optional<State> state = stateRepository.findById(id);
		return state.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public State save(State state) {
		return stateRepository.save(state);
	}

	public void delete(UUID id) {
		try {
		stateRepository.deleteById(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public void updateData(State entity, State obj) {
		entity.setName(obj.getName());
		entity.setAbbreviation(obj.getAbbreviation());
	}

	public State update(UUID id, State state) {
		try {
		State entity = stateRepository.getReferenceById(id);
		updateData(entity, state);
		return stateRepository.save(entity);
		} catch (NullPointerException e) {
			throw new ResourceNotFoundException(id);
		}
	}

}
