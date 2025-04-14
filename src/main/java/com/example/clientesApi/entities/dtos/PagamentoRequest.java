package com.example.clientesApi.entities.dtos;

import java.time.Instant;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PagamentoRequest {
	
	private Instant momentoPagamento;

	public PagamentoRequest(Instant momentoPagamento) {
		this.momentoPagamento = Instant.now();
	}
	
	
}
