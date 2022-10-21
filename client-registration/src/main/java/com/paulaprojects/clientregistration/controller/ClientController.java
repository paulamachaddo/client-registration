package com.paulaprojects.clientregistration.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

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

import com.paulaprojects.clientregistration.entities.Client;
import com.paulaprojects.clientregistration.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = clientService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable UUID id) {
		Client client = clientService.findById(id);
		return ResponseEntity.ok().body(client);
	}

	@PostMapping
	public ResponseEntity<Client> save(@RequestBody Client client) {
		client = clientService.save(client);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
		return ResponseEntity.created(uri).body(client);
	}

	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Client> update(@PathVariable UUID id, @RequestBody Client client) {
		client = clientService.update(id, client);
		return ResponseEntity.ok().body(client);
	}

}
