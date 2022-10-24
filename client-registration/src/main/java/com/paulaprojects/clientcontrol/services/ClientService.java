package com.paulaprojects.clientregistration.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulaprojects.clientregistration.entities.Client;
import com.paulaprojects.clientregistration.exceptions.ResourceNotFoundException;
import com.paulaprojects.clientregistration.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> findAll(){
		return clientRepository.findAll();
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
