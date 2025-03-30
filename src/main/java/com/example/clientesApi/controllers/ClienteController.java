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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/clientes")
@RequiredArgsConstructor
public class ClienteController {
	
	private final ClienteService clienteService;
	@Operation(description = "Salva um Cliente no banco de dados.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Salva um cliente."),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos.")
	})
	@PostMapping
	public ResponseEntity<Cliente> registrarCliente(@RequestBody ClienteRequest cliente) {
		Cliente salvo = clienteService.salvar(cliente);
		return ResponseEntity.ok().body(salvo);
	}
	
	@Operation(description = "Resgata um cliente do banco de dados pelo id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna um cliente."),
			@ApiResponse(responseCode = "404", description = "Não existe cliente no id informado.")
	})
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteResponse> resgatarClientePorId(@PathVariable Long id){
		ClienteResponse cliente = clienteService.resgatarPorId(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@Operation(description = "Resgata uma lista de todos os clientes do banco de dados.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Retorna uma lista de clientes.") })
	@GetMapping
	public ResponseEntity<List<ClienteResponse>> resgatarTodosClientes() {
		var clientes = clienteService.resgatarTodos();
		return ResponseEntity.ok().body(clientes);
	}
	
	@Operation(description = "Atualiza um cliente no banco de dados pelo id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Efetua a atualização do cliente."),
			@ApiResponse(responseCode = "404", description = "Não existe cliente no id informado."),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos.")
	})
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizarUsuarioPorId(@PathVariable Long id, @RequestBody ClienteRequest clienteAtualizado) {
		clienteService.atualizarCliente(id, clienteAtualizado);
		return ResponseEntity.noContent().build();
	}
}
