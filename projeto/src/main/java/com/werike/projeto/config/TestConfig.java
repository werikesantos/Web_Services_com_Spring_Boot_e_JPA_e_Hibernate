package com.werike.projeto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.werike.projeto.entidades.Pedido;
import com.werike.projeto.entidades.Usuario;
import com.werike.projeto.repositories.PedidoRepository;
import com.werike.projeto.repositories.UsuarioRepository;

//CRIANDO UMA CLASSE ESPECIFICA PARA PERFIL DE TESTE
@Configuration
public class TestConfig  implements CommandLineRunner{//CommandLineRunner => É UMA INTERFACE E PRECISA IMPLEMENTAR OS METODOS
	
	@Autowired //ANOTAÇÃO RESPONSAVEL PARA RESOLVEU UMA DEPENDENCIA E ASSOCIAR UMA INSTANCIA
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public void run(String... args) throws Exception {// OQUE ESTIVER DENTRO DESSE MÉTODO SERÁ RODADO QUANDO A APLICAÇÃO FOR INICIADA.

		//POPULANDO O MEU BANCO DE DADOS TESTE
		Usuario usuario1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario usuario2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");	
		
		Pedido pedido1 = new Pedido(null, Instant.parse("2021-07-26T19:43:07Z"), usuario1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2021-07-26T19:43:07Z"), usuario2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2021-07-26T19:43:07Z"), usuario2);
		
		//SALVANDO SOMENTE UM OBJETO => usuarioRepository.save(usuario1);
		//SALVANDO UMA LISTA DE OBJETOS => usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
	}	
}