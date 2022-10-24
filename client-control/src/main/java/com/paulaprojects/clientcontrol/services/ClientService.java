package com.paulaprojects.clientcontrol.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.paulaprojects.clientcontrol.entities.Client;
import com.paulaprojects.clientcontrol.exceptions.ResourceNotFoundException;
import com.paulaprojects.clientcontrol.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Page<Client> findAll(Pageable pageable){
		return clientRepository.findAll(pageable);
	}
	
//	Método para encontrar o cliente pelo id, e caso ele não exista lança uma exceção com status 404 com mensagem adaptada.
	
	public Client findById(UUID id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	
	public void delete(UUID id) {
		clientRepository.deleteById(id);
	}
	
	public void updateData (Client entity, Client obj) {
		entity.setName(obj.getName());
		entity.setAddress(obj.getAddress());
		entity.setCity(obj.getCity());
		entity.setGender(obj.getGender());
		entity.setPhone(obj.getPhone());
	}
	
	public Client update(UUID id, Client client) {
		Client entity = clientRepository.getReferenceById(id);
		updateData(entity, client);
		return clientRepository.save(entity);
	}
}
