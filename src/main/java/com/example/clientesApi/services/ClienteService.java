package com.example.clientesApi.services;

import org.springframework.stereotype.Service;

import com.example.clientesApi.entities.Cliente;
import com.example.clientesApi.repositories.ClienteRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		Cliente clienteSalvo = clienteRepository.save(cliente);
		return clienteSalvo;
	}
	
	@Transactional
	public Cliente resgatarPorId(Long id) {
		Cliente cliente = clienteRepository.getReferenceById(id);
		return cliente;
	}
}
