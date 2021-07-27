package com.werike.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.werike.projeto.entidades.Pedido;
import com.werike.projeto.repositories.PedidoRepository;

@Service 
public class PedidoService {
	
	@Autowired 
	private PedidoRepository pedidoRepository; 
	
	public List<Pedido> buscar(){
		return pedidoRepository.findAll();
	}
	
	public Pedido buscarPorId(Long id) {
		Optional<Pedido> usuarioOBJ = pedidoRepository.findById(id);
		return usuarioOBJ.get();
	}
}