package com.werike.projeto.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.werike.projeto.entidades.Usuario;

/*ESSE É UM MODELO DE CONTROLADOR REST QUE RESPONDE AO CAMINHO (/usuario)*/
	@RestController
	@RequestMapping("/usuario")
	public class UsuarioResource {
	
		@GetMapping //Anotação para mapear solicitações HTTP GET em métodos de tratamento específicos.
		public ResponseEntity<Usuario> retornarTodos(){
		//ResponseEntity => É UM TIPO ESPECIFICO DO SPRING PARA RETORNAR RESPOSTAS DE REQUISIÇÕES WEB
			
			//INSTANCIANDO UM OBJETO
			Usuario usuarios = new Usuario(1L, "Werike", "werike@gmail.com", "11 9-8595-0519", "1234");
			
			//RETORNANDO O OBJETO NO CORPO DO HTML
			return ResponseEntity.ok().body(usuarios); 
			//ResponseEntity.ok() => RETORNA A RESPOSTA COM SUCESSO NO HTTP
			//.body(usuarios) => RETORNA NO CORPO DO HTML O MEU OBJETO.
		}
		
		//OBS: TESTE REALIZADO NA PORTA '...8080/usuario' RETORNANDO O OBJETO NO PADRÃO JSON
		//{"id":1,"name":"Werike","email":"werike@gmail.com","telefone":"11 9-8595-0519","senha":"1234"}
		
/*FIM*/
}