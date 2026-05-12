package com.devsuperior.desafio3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.desafio3.dto.ClientDTO;
import com.devsuperior.desafio3.entities.Client;
import com.devsuperior.desafio3.repositories.ClientRepository;

import jakarta.transaction.Transactional;

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

	public ClientDTO findById(Long id) {
		Client client = repository.findById(id).get();
		return new ClientDTO(client);
	}

	/*
	 * public ResponseEntity<Pageable<ClientDTO>> findAll(){
	 * 
	 * }
	 * 
	 * public ResponseEntity<ClientDTO> update(Long id, ClientDTO dto) {
	 * 
	 * }
	 * 
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
