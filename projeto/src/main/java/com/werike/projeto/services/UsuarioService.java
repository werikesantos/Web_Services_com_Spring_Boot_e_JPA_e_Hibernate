package com.werike.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.werike.projeto.entidades.Usuario;
import com.werike.projeto.repositories.UsuarioRepository;

//CLASSE RESPONSÁVEL PELOS SERVIÇOS
//ELA RECEBE A REQUISIÇÃO DA CLASSE CONTROLADORA PROCESSA OS DADOS E FAZ A LIGAÇÃO COM A REPOSITORY
@Service //SEM ESSA ANOTAÇÃO NAO FUNCIONA
public class UsuarioService {
	
	@Autowired //ANOTAÇÃO RESPONSAVEL PELA CRIAÇÃO DE UMA INSTANCIA
	private UsuarioRepository usuarioRepository; 
	
	//MÉTODO QUE RETORNA TODOS OS USUARIO DO BANCO
	public List<Usuario> buscar(){
		return usuarioRepository.findAll();
	}
	
	//MÉTODO QUE RETORNA UMA CONSULTA POR ID
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuarioOBJ = usuarioRepository.findById(id);
		return usuarioOBJ.get();
	}
}