package com.werike.projeto.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//CONFIGURANDO A MINHA ENTIDADE COM ANNOTETION DO JPA(ESSA ANOTAÇÃO SERVE PARA O JPA CONVERTER OS OBJETOS PARA O MODELO RELACIONAL)
//import javax.persistence.Entity; => TEM QUE SER ADICIONADO ESSE DA ESPECIFICAÇÃO
@Entity
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