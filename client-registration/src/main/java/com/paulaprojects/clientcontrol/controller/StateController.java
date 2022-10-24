package com.paulaprojects.clientregistration.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.paulaprojects.clientregistration.entities.State;
import com.paulaprojects.clientregistration.services.StateService;

@RestController
@RequestMapping(value = "/states")
public class StateController {

	@Autowired
	private StateService stateService;

	@GetMapping
	public ResponseEntity<List<State>> findAll() {
		List<State> list = stateService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<State> findById(@PathVariable UUID id) {
		State state = stateService.findById(id);
		return ResponseEntity.ok().body(state);
	}

	@PostMapping
	public ResponseEntity<State> save(@RequestBody State state) {
		state = stateService.save(state);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(state.getId()).toUri();
		return ResponseEntity.created(uri).body(state);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		stateService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<State> update(@PathVariable UUID id, @RequestBody State state) {
		state = stateService.update(id, state);
		return ResponseEntity.ok().body(state);
	}

}
