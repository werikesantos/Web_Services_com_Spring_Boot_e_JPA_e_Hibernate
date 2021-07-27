package com.werike.projeto.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//CONFIGURANDO A MINHA ENTIDADE COM ANNOTETION DO JPA(ESSA ANOTAÇÃO SERVE PARA O JPA CONVERTER OS OBJETOS PARA O MODELO RELACIONAL)
//import javax.persistence.Entity; => TEM QUE SER ADICIONADO ESSE DA ESPECIFICAÇÃO
@Entity
@Table(name = "usuario") //@Table(name = "pedido") => NOMEANDO A TABELA
public class Usuario implements Serializable{//Serializable => SERVE PARA O OBJETO TRAFEGE NA REDE E POSSA SER GRAVADO EM ARQUIVOS
	private static final long serialVersionUID = 1L; //É UM NÚMERO DE SERIE PADRÃO
	
	//PROXIMO PASSO É DIZER PARA O JPA QUAL É A MINHA CHAVE PRIMARIA DO BANCO DE DADOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //ESSA ANOTAÇÃO INDICA QUE ESSA CHAVE PRIMARIA É AUTO INCREMENT
	private Long id;
	private String name;
	private String email;
	private String telefone;
	private String senha;
	
	//FAZENDO A ASSOCIAÇÃO DAS CLASSES USUARIO E PEDIDO
	@JsonIgnore //ATENÇÃO: ESSA ANOTAÇÃO DEVE SER COLOCADA QUANDO EXISTIR CLASSES ASSOCIADAS E DO LADO UM PARA MUITOS. ASSIM, SERÁ RETORNADO NO JSON O LADO UM, CARREGANDO OS OBJETOS ASSOCIADOS DE MUITOS.
 	@OneToMany(mappedBy = "cliente") //ANOTAÇÃO DE UM PARA MUITOS => UM USUARIO ASSOCIADO A UM OU VARIOS PEDIDOS
	//(mappedBy = "cliente") => AQUI EU DESCREVO QUE A CHAVE ESTRANGEIRA ESTA LIGADA AO ATRIBUTO "cliente" NA CLASSE PEDIDO.
 	private List<Pedido> pedidos = new ArrayList<>(); //OU SEJA, UM USUÁRIO PODE ESTAR ASSOCIADO A UM OU VÁRIOS PEDIDOS; E VÁRIOS PEDIDOS PODEM ASSOCIADOS A UM USUARIO.
	//ATENÇÃO!!!
	//QUANDO É INSTANCIADO UMA COLEÇÃO DE ARRAYLIST, SÓ DEVE SER CRIADO O MÉTODO GET. O METODO SET NÃO É PARA SER CRIADO.
	
	
	public Usuario() {
	}
	
	public Usuario(Long id, String name, String email, String telefone, String senha) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", name=" + name + ", email=" + email + ", telefone=" + telefone + ", senha="
				+ senha + "]";
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
}