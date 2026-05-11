package com.devsuperior.desafio3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.desafio3.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	/*public ResponseEntity<ClientDTO> insert(ClientDTO dto) {
		
	}
	
	public ResponseEntity<ClientDTO> findById(Long id) {
		
	}
	
	public ResponseEntity<Pageable<ClientDTO>> findAll(){
		
	}
	
	public ResponseEntity<ClientDTO> update(Long id, ClientDTO dto) {
		
	}
	
	public ResponseEntity<Void> delete(Long id){
		
	}*/
}
