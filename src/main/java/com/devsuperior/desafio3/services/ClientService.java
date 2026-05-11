package com.devsuperior.desafio3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.desafio3.dto.ClientDTO;
import com.devsuperior.desafio3.entities.Client;
import com.devsuperior.desafio3.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public ClientDTO insert(ClientDTO dto) {
		
		Client client = new Client();
		copyDtotoClient(dto, client);
		client = repository.save(client);
		
		return new ClientDTO(client);
	}

	private void copyDtotoClient(ClientDTO dto, Client client) {
		
		client.setName(dto.getName());
		client.setCpf(dto.getCpf());
		client.setIncome(dto.getIncome());
		client.setBirthDate(dto.getBirthDate());
		client.setChildren(dto.getChildren());
		
	}
	
	/*public ResponseEntity<ClientDTO> findById(Long id) {
		
	}
	
	public ResponseEntity<Pageable<ClientDTO>> findAll(){
		
	}
	
	public ResponseEntity<ClientDTO> update(Long id, ClientDTO dto) {
		
	}
	
	public ResponseEntity<Void> delete(Long id){
		
	}*/
}
