package com.example.clientesApi.services;

import org.springframework.stereotype.Service;

import com.example.clientesApi.repositories.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
}
