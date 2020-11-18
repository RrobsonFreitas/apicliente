package com.apicliente.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/")
public class IndexController {
	
	
	@GetMapping()
	public String get() {
		return "API dos Clientes";
	}
	
	
	
//   TESTE INICIAL
//	
//	@GetMapping()
//	public String get() {
//		return "Get Spring Boot";
//	}
//	
// GET COM PASSAGEM DE PARAMETRO (fica visível no link da URI)
//	@GetMapping("/login")
//	public String login(@RequestParam ("ParamdoLogin") String login, @RequestParam("ParamdaSenha")  String senha) {
//		// Ai passa como parâmetro na chamada separando com ? e &
//		// http://localhost:8080/transactions/login?ParamdoLogin=Robson&ParamdaSenha=123
//		return "Login " + login + ", Senha " + senha;
//	}
//	
// EXMPLO DE PARÂMETRO COM PATH
//	@GetMapping("/login/{ParamdoLogin}/{ParamdaSenha}")
//	public String login(@PathVariable ("ParamdoLogin") String login, @PathVariable("ParamdaSenha")  String senha) {
//		// Com o PathVariable só pracisa passar o login e a senha (sem ? e &)
//		// http://localhost:8080/transactions/login/Robson/123
//		return "Login " + login + ", Senha " + senha;
//	}
//
//	Com o GetMapping abaixo eu posso passar outro endpoint
//	@GetMapping("/teste")
//	public String teste() {
//		return "Teste Sprint Boot";
//	}
	
	
//	POST COM PARÂMETRO
//	@PostMapping("/login")
//	public String login(@RequestParam ("ParamdoLogin") String login, @RequestParam("ParamdaSenha")  String senha) {
//		// Ai vai no Body do Postman e passa como parâmetro o ParamdoLogin e ParamdaSenha no x-www-form-urlencoded
//		// O login e a senha não vai na URL (vai no corpo)
//		return "Login " + login + ", Senha " + senha;
//	}
	
	
	
	
//	@PostMapping()
//	public String post() {
//		return "Post Spring Boot";
//	}
//	
//	@PutMapping()
//	public String put() {
//		return "Put Spring Boot";
//	}
//	
//	@DeleteMapping()
//	public String delete() {
//		return "Delete Spring Boot";
//	}
//	
	
	
	

	
	
	
}



