package com.example.clientesApi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientesApi.services.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/clientes")
@RequiredArgsConstructor
public class ClienteController {
	
	private final ClienteService clienteService;
}
