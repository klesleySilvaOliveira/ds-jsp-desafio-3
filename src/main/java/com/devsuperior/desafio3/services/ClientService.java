package com.devsuperior.desafio3.services;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.desafio3.dto.ClientDTO;
import com.devsuperior.desafio3.entities.Client;
import com.devsuperior.desafio3.repositories.ClientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional
	public ClientDTO insert(ClientDTO dto) {

		Client client = new Client();
		copyDtotoClient(dto, client);
		client = repository.save(client);

		return new ClientDTO(client);
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client client = repository.findById(id).get();
		return new ClientDTO(client);
	}

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable) {
		return repository.findAll(pageable).map(x -> new ClientDTO(x));
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {			
			Client client = repository.getReferenceById(id);
			copyDtotoClient(dto, client);
			client = repository.save(client);
			
			return new ClientDTO(client);
		} 
		catch (EntityNotFoundException e) {
			throw new RuntimeErrorException(null, e.getMessage());
		}
		
	}

	/*
	 * public ResponseEntity<Void> delete(Long id){
	 * 
	 * }
	 */

	private void copyDtotoClient(ClientDTO dto, Client client) {

		client.setName(dto.getName());
		client.setCpf(dto.getCpf());
		client.setIncome(dto.getIncome());
		client.setBirthDate(dto.getBirthDate());
		client.setChildren(dto.getChildren());

	}
}
