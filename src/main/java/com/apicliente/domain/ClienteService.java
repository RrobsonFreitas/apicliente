package com.apicliente.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.apicliente.domain.dto.ClienteDTO;
import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.apicliente.api.exception.*;


@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repositorio;

// ------------------ RETORNA TODOS OS CLIENTES -----------------------
	// O CÓDIGO ABAIXO FOI ANTES DO DTO
//	public Iterable<Cliente> getClientes(){
//		return repositorio.findAll();
//	}

	public List<ClienteDTO> getClientes(){
		//List<Cliente> clientes = repositorio.findAll();
		
		// O código abaixo faz a mesma coisa o for comentado
		//List<ClienteDTO> list = clientes.stream().map(c -> ClienteDTO.create(c)).collect(Collectors.toList());
		//List<ClienteDTO> list = repositorio.findAll().stream().map(ClienteDTO::create).collect(Collectors.toList());
		// return repositorio.findAll().stream().map(ClienteDTO::create).collect(Collectors.toList());
		return repositorio.findAll().stream().map(ClienteDTO::create).collect(Collectors.toList());
		
//		List<ClienteDTO> list = new ArrayList<>();
//		for (Cliente c : clientes) {
//			list.add(new ClienteDTO(c));
//		}
		
		//return list;
	}
	
	
// ----------------- RETORNA CLIENTE PASSANDO O ID NO PARÂMETRO -------------------------------
	// AQUI FOI ANTES DO DTO
//	public Optional<Cliente> getClientesById(Long id) {
//		return repositorio.findById(id);
//	}

    public ClienteDTO getClientesById(Long id) {
        Optional<Cliente> cliente = repositorio.findById(id);
        return cliente.map(ClienteDTO::create).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
    }

		
//		Optional<Cliente> cliente = repositorio.findById(id);
//		if(cliente.isPresent()) {
//			return Optional.of(new ClienteDTO(cliente.get()));
//		}else {
//			return null;
//		}
		
	//}
	
	
	
// ---------------- INSERE (CADASTRA) CLIENTE-----------------------
	
	// SEM DO DTO
//	public Cliente insert(Cliente cliente) {
//		Assert.notNull(cliente.getId(), "Não foi possível inserir o registro");
//	    return repositorio.save(cliente);
//	}
		
	// COM DTO (nao consegui retornar 201 nem o location
	public ClienteDTO insert(Cliente cliente) {
		//Assert.notNull(cliente.getId(), "Não foi possível inserir o registro");
		Assert.isNull(cliente.getId(), "Não foi possível inserir o registro");
	    return ClienteDTO.create(repositorio.save(cliente));
	}
	
	
	
//-------------- ALTERA (UPDATE) CLIENTE ----------------------------
	// ANTES DO DTO
//	public Cliente update(Cliente cliente, Long id) {
//		Assert.notNull(id, "Não foi possível atualizar o registro");
//		
//		//Busca o ccliente no banco de dados
//		Optional<Cliente> optional = getClientesById(id);
//		if (optional.isPresent()) { //verificar se o cliente existe
//			Cliente db = optional.get();
//			//Copiar as propriedades
//			db.setNome(cliente.GetNome());
//			System.out.println("Cliente id " + db.getId());
//			
//			// Atualiza o cliente
//			repositorio.save(db);
//			
//			return db;
//		} else {
//			throw new RuntimeException("Não foi possível atualizar o registro");
//		}
//	}


	
	
	// APAGARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
//	private ClienteDTO ClienteDTO(Cliente save) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	public ClienteDTO update(Cliente cliente, Long id) {
		Assert.notNull(id, "Não foi possível atualizar o registro");
		
		//Busca o ccliente no banco de dados
		Optional<Cliente> optional = repositorio.findById(id);
		if (optional.isPresent()) { //verificar se o cliente existe
			Cliente db = optional.get();
			//Copiar as propriedades
			db.setNome(cliente.getNome());
			db.setNumeroconta(cliente.getNumeroconta());
			System.out.println("Cliente id " + db.getId());
			
			// Atualiza o cliente
			repositorio.save(db);
			
			return ClienteDTO.create(db);
		} else {
			return null;
			//throw new RuntimeException("Não foi possível atualizar o registro");
		}
	}
	
	
	
	
	
	
	
	
// ----------------- DELETA CLIENTE PASSANDO O ID NO PARÂMETRO -------------------------------	
	
	// ANTES DO DTO
//	public void delete (Long id) {
//		Optional<Cliente> cliente = getClientesById(id);
//		if(cliente.isPresent()) {
//			repositorio.deleteById(id);
//		}
//	return null;
//	}
	
	// ANTES DE TRATAR AS EXCEÇÕES
//	public boolean delete (Long id) {
//		if(getClientesById(id).isPresent()) {
//			repositorio.deleteById(id);
//			return true;
//		}
//		return false;
//	}
	
	
	public void delete (Long id) {
			repositorio.deleteById(id);

	}
	
	
	
	
}
	
	
	
	
//  PARA TESTAR NA MEMÓRIA		
//		public List<Cliente> getClientes(){
//			List<Cliente> clientes = new ArrayList<>();
//			clientes.add(new Cliente(id:1L, nome:"eeee"));
//		return clientes;
//	}
	


