package com.example.clientesApi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.clientesApi.entities.Cliente;
import com.example.clientesApi.entities.dtos.ClienteRequest;
import com.example.clientesApi.entities.dtos.ClienteResponse;
import com.example.clientesApi.repositories.ClienteRepository;
import com.example.clientesApi.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(ClienteRequest cliente) {
		Cliente clienteSalvo = new Cliente(cliente.getNome(),cliente.getCpf(),cliente.getEmail(),cliente.getSenha(),cliente.getTelefone());
		clienteRepository.save(clienteSalvo);
		return clienteSalvo;
	}
	
	@Transactional
	public ClienteResponse resgatarPorId(Long id) {
		try {
			Cliente cliente = clienteRepository.getReferenceById(id);
			return ClienteResponse
					.builder()
					.cpf(cliente.getCpf())
					.email(cliente.getEmail())
					.id(cliente.getId())
					.senha(cliente.getSenha())
					.telefone(cliente.getTelefone())
					.nome(cliente.getNome())
					.build();
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	@Transactional
	public List<ClienteResponse> resgatarTodos(){
		var clientes = clienteRepository.findAll();
		return clientes.stream().map((x) -> ClienteResponse
				.builder()
				.cpf(x.getCpf())
				.email(x.getEmail())
				.id(x.getId())
				.nome(x.getNome())
				.senha(x.getSenha())
				.telefone(x.getTelefone())
				.build())
				.toList();
	}
	
	@Transactional
	public void atualizarCliente (Long id, ClienteRequest clienteAtualizado) {
		try {
			var clienteAntigo = clienteRepository.getReferenceById(id);
			update(clienteAntigo,clienteAtualizado);
			clienteRepository.save(clienteAntigo);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	
	public void update(Cliente antigo, ClienteRequest atualizado) {
		antigo.setCpf(atualizado.getCpf());
		antigo.setNome(atualizado.getNome());
		antigo.setEmail(atualizado.getEmail());
		antigo.setSenha(atualizado.getSenha());
		antigo.setTelefone(atualizado.getTelefone());
	}
}
