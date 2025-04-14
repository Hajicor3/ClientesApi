package com.example.clientesApi.entities.dtos;

import java.util.HashSet;
import java.util.Set;

import com.example.clientesApi.entities.enums.StatusPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoRequest {
	
	private Long clienteId;
	private StatusPedido status;
	private PagamentoRequest pagamento;
	private Set<ItemPedidoRequest> items= new HashSet<>();
}
