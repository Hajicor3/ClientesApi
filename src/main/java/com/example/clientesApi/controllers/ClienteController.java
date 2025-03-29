package com.example.clientesApi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientesApi.entities.Cliente;
import com.example.clientesApi.services.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/clientes")
@RequiredArgsConstructor
public class ClienteController {
	
	private final ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente) {
		Cliente salvo = clienteService.salvar(cliente);
		return ResponseEntity.ok().body(salvo);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> resgatarClientePorId (@PathVariable Long id){
		Cliente cliente = clienteService.resgatarPorId(id);
		return ResponseEntity.ok().body(cliente);
	}
}
