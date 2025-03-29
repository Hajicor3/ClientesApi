package com.example.clientesApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clientesApi.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
