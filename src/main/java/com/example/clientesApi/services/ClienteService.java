package com.example.clientesApi.services;

import java.util.List;

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
	
	@Transactional
	public List<Cliente> resgatarTodos(){
		var clientes = clienteRepository.findAll();
		return clientes;
	}
	
	public void atualizarCliente (Long id, Cliente clienteAtualizado) {
		var clienteAntigo = clienteRepository.getReferenceById(id);
		update(clienteAntigo,clienteAtualizado);
		clienteRepository.save(clienteAntigo);
		
	}
	
	public void update(Cliente antigo, Cliente atualizado) {
		antigo.setCpf(atualizado.getCpf());
		antigo.setNome(atualizado.getNome());
		antigo.setEmail(atualizado.getEmail());
		antigo.setSenha(atualizado.getSenha());
		antigo.setTelefone(atualizado.getTelefone());
	}
}
