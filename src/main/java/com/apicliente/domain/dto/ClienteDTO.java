package com.apicliente.domain.dto;

import javax.persistence.Column;
import org.modelmapper.ModelMapper;
import com.apicliente.domain.Cliente;
import lombok.*;


//COM MODEL MAPPER 
@Data
public class ClienteDTO {
	private Long id;
	private String nome;
	private Long numeroconta;
	
	public static ClienteDTO create(Cliente c) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(c, ClienteDTO.class);
	}
	

// ANTES DO MODEL MAPPER
//public class ClienteDTO {
//	private Long id;
//	private String nome;
//	private Long numeroconta;
//	
//    public ClienteDTO(Cliente cliente) {
//    this.id = cliente.getId();
//    this.nome = cliente.getNome();
//    this.numeroconta = cliente.getNumeroconta();
//}


}
