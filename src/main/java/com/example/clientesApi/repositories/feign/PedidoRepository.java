package com.example.clientesApi.repositories.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.clientesApi.entities.dtos.PedidoRequest;

@FeignClient(name = "apipedidos", url = "http://localhost:8083/pedidos")
public interface PedidoRepository {
	
	@PostMapping
	public ResponseEntity<PedidoRequest> criarPedido(@RequestBody PedidoRequest pedido);
}
