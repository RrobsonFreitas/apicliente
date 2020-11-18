package com.apicliente.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

// COMUNICA COM O BANCO DE DADOS
// public interface ClienteRepository extends CrudRepository<Cliente, Long>{ //AQUI FOI ANTES DO DTO
	
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	//Optional<Cliente> findById(Long id);
	
}