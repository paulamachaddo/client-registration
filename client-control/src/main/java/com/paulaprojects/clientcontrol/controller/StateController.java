package com.paulaprojects.clientcontrol.controller;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.paulaprojects.clientcontrol.entities.State;
import com.paulaprojects.clientcontrol.services.StateService;

@RestController
@RequestMapping(value = "/states")
public class StateController {

	@Autowired
	private StateService stateService;

	@GetMapping
	public ResponseEntity<Page<State>> findAll(Pageable pageable) {
		Page<State> list = stateService.findAll(pageable);
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
