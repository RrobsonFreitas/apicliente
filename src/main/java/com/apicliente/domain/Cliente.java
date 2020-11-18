package com.apicliente.domain;
import javax.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;


@Data
@Entity (name = "bytebank" ) //mapeia a tabela bytebank para a classe

public class Cliente {
	
	@Id  //indica que é a chave primária da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // A JPA vai fazer o autoincremento
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome") //Para definir quando a string seja diferente da coluna do banco
	private String nome;
	
	@Column(name = "numeroconta") 
	private Long numeroconta;
	
	
//	
//	// COMENTAR DAQUI ATÉ O FINAL, POIS O LOMBOK FAZ TUDO SOZINHO COM A IMPORTAÇÃO E USANDO O @Data
//	public Cliente() {} // Construtor padrão sem nenhum parâmetro para não dar erro 
//	
//	public Cliente(Long id, String nome, Long numeroconta) {
//		this.id = id;
//		this.nome = nome;
//		this.numeroconta = numeroconta;
//		}
//	
//	public Long getId() {
//		return id;
//	}
//	
//	public void SetId(Long id) {
//		this.id = id;
//	}
//	
//	public String GetNome() {
//		return nome;
//	}
//	
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//	
//	public Long GetNumeroconta() {
//		return numeroconta;
//	}
//	
//	public void setNumeroconta(Long numeroconta) {
//		this.numeroconta = numeroconta;
//	}
	
	
	
	
}