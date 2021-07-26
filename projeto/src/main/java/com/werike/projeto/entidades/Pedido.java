package com.werike.projeto.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido") //@Table(name = "pedido") => NOMEANDO A TABELA
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant instante; //CLASSE INSTANTE PRECUSSORA DA CLASSE DATE
	
	//FAZENDO A ASSOCIAÇÃO DAS CLASSES USUARIO E PEDIDO
	@ManyToOne //ANOTAÇÃO DE MUITOS PARA UM => VARIOS PEDIDOS ASSOCIADOS A UM USUARIO/CLIENTE.
	@JoinColumn(name = "id_cliente") // @JoinColumn(name = "id_cliente") => DEFINI O NOME DA CHAVE ESTRANGEIRA
	private Usuario cliente; //OU SEJA, UM USUÁRIO PODE ESTAR ASSOCIADO A UM OU VÁRIOS PEDIDOS; E VÁRIOS PEDIDOS PODEM ASSOCIADOS A UM USUARIO.

	public Pedido() {
	}
	
	public Pedido(Long id, Instant instante, Usuario cliente) {
		super();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getInstante() {
		return instante;
	}

	public void setInstante(Instant instante) {
		this.instante = instante;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", instante=" + instante + ", cliente=" + cliente + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
}