package com.werike.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.werike.projeto.entidades.Pedido;

@Repository 
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
}