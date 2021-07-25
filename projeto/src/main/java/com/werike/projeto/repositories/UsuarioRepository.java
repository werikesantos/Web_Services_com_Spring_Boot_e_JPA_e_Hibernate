package com.werike.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.werike.projeto.entidades.Usuario;

//O JPA É UMA INTERFACE E POR ISSO DEVE SER CRIADO UMA CLASSE REPOSITORY COMO INTERFACE TAMBÉM
@Repository //ESSA ANOTAÇÃO NÃO É OPCIONAL E NÃO NECESSÁRIO POIS ELA ESTA SENDO HERDADA PELA JpaRepository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{//USUARIO É A CLASSE E LONG É O TIPO USAD NO ID
	//CLASSE RESPONSÁVEL PELAS OPERAÇÕES PARA TRABALHAR COM O USUARIO
	
	//NÃO PRECISA DE IMPLEMETAÇÃO POIS O 'JpaRepository' JÁ CRIA AS IMPLEMENTAÇÕES. SOMENTE ASSIM JÁ ESTA PRONTO A CLASSE.
}