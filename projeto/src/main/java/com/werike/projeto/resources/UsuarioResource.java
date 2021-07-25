package com.werike.projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.werike.projeto.entidades.Usuario;
import com.werike.projeto.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	/*
	@GetMapping 
	public ResponseEntity<Usuario> retornarTodos(){
		Usuario usuarios = new Usuario(1L, "Werike", "werike@gmail.com", "11 9-8595-0519", "1234");
		return ResponseEntity.ok().body(usuarios); 
	}
	*/
	
	@GetMapping 
	public ResponseEntity<List<Usuario>> buscar(){
		List<Usuario> usuarios = usuarioService.buscar();
		return ResponseEntity.ok().body(usuarios); 
	}
	
	@GetMapping(value = "/{id}") // /{id} => INDICA QUE A MINHA REQUISIÇÃO VAI RECEBER UM 'id' DENTRO DA URL
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){ //@PathVariable => SERVE PARA PEGAR O DADO ENVIADO PELA REQUISIÇÃO.
		Usuario usuarios = usuarioService.buscarPorId(id);
		return ResponseEntity.ok().body(usuarios);
	}
}