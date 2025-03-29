package com.example.clientesApi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientesApi.entities.Cliente;
import com.example.clientesApi.entities.dtos.ClienteRequest;
import com.example.clientesApi.entities.dtos.ClienteResponse;
import com.example.clientesApi.services.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/clientes")
@RequiredArgsConstructor
public class ClienteController {
	
	private final ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> registrarCliente(@RequestBody ClienteRequest cliente) {
		Cliente salvo = clienteService.salvar(cliente);
		return ResponseEntity.ok().body(salvo);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteResponse> resgatarClientePorId(@PathVariable Long id){
		ClienteResponse cliente = clienteService.resgatarPorId(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteResponse>> resgatarTodosClientes() {
		var clientes = clienteService.resgatarTodos();
		return ResponseEntity.ok().body(clientes);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizarUsuarioPorId(@PathVariable Long id, @RequestBody ClienteRequest clienteAtualizado) {
		clienteService.atualizarCliente(id, clienteAtualizado);
		return ResponseEntity.noContent().build();
	}
}
