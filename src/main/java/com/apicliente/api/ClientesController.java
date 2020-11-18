package com.apicliente.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.apicliente.domain.Cliente;
import com.apicliente.domain.ClienteService;
import com.apicliente.domain.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.apicliente.api.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.modelmapper.ModelMapper;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
	@Autowired
	private ClienteService service;
	
	@GetMapping()
	public ResponseEntity <List<ClienteDTO>> get() {
	//public ResponseEntity <Iterable<Cliente>> get() { AQUI FOI ANTES DE USAR O DTO
		return ResponseEntity.ok(service.getClientes());   // Código 200 da resposta do HTTP
		//return new ResponseEntity<> (service.getClientes(), HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		ClienteDTO cliente = service.getClientesById(id);
		
//		// PODE FAZER COM LAMBDA
//		return cliente.map(c -> ResponseEntity.ok(c))
//				.orElse(ResponseEntity.notFound().build());
				
		
		// PODE FAZER COM ESSE TIPO DE IF COM ? 
		return ResponseEntity.ok(cliente);
				

				
//		// PODE FAZER COM ESSE IF TAMBÉM
//		if(cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get());
//		}else {
//			return ResponseEntity.notFound().build();
//		}
		
	}
	
	
	
	
	@PostMapping
	public ResponseEntity post(@RequestBody  Cliente cliente) {
		ClienteDTO c = service.insert(cliente);
		URI location = getUri(c.getId());
		return ResponseEntity.created(location).build();
 }

	
	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
		
	// SEM do DTO
//	public String post(@RequestBody  Cliente cliente) {
//		Cliente c =	service.insert(cliente);
//		return "Cliente salvo com sucesso: " + c.getId();
	//
//	}
	
	
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Cliente cliente ) {
		cliente.setId(id);
		ClienteDTO c = service.update(cliente, id);
		return c != null ?
				ResponseEntity.ok(c) :
				ResponseEntity.notFound().build();
	}	
	
	// SEM DTO
//	public String put(@PathVariable("id") Long id, @RequestBody Cliente cliente ) {
//		Cliente c = service.update(cliente, id);
//		return "Cliente atualizado com sucesso: " + c.getId();
//	}
	
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		service.delete(id);
		return	ResponseEntity.ok().build();
	 }		
	}
	
	// ANTES DE TRATAR AS EXEÇÕES
//	@DeleteMapping("/{id}")
//	public ResponseEntity delete(@PathVariable("id") Long id) {
//		boolean ok = service.delete(id);
//		return ok ?
//				ResponseEntity.ok().build() :
//				ResponseEntity.notFound().build();				
//	}
	
	// ANTES DO DTO
//	@DeleteMapping("/{id}")
//	public String delete(@PathVariable("id") Long id) {
//		service.delete(id);
//		return "Cliente deletado com sucesso"; 
//	}
	
	




