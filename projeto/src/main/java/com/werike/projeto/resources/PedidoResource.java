package com.werike.projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.werike.projeto.entidades.Pedido;
import com.werike.projeto.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping 
	public ResponseEntity<List<Pedido>> buscar(){
		List<Pedido> pedidos = pedidoService.buscar();
		return ResponseEntity.ok().body(pedidos); 
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id){
		Pedido pedidos = pedidoService.buscarPorId(id);
		return ResponseEntity.ok().body(pedidos);
	}
}