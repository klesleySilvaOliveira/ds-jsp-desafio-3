package com.devsuperior.desafio3.dto;

import java.time.LocalDate;

import com.devsuperior.desafio3.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class ClientDTO {

	private Long id;
	
	@NotBlank(message = "The name must not be blank!")
	private String name;
	
	@Size(min = 1, max = 11, message = "The cpf must have, at least, 1 char and be up to 11 chars!")
	@NotBlank(message = "The cpf must not be blank!")
	private String cpf;
	
	@PositiveOrZero(message = "The income must be zero or positive!")
	private Double income;
	
	@PastOrPresent(message = "The birth date must not be a future date!")
	private LocalDate birthDate;
	
	@PositiveOrZero(message = "Must not have below zero childrens!")
	private Integer children;
	
	public ClientDTO() {
		super();
	}

	public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}
	
	public ClientDTO(Client client) {
		super();
		id = client.getId();
		name = client.getName();
		cpf = client.getCpf();
		income = client.getIncome();
		birthDate =  client.getBirthDate();
		children = client.getChildren();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getIncome() {
		return income;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Integer getChildren() {
		return children;
	}
	
	
}
