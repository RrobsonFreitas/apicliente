package com.apicliente;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import static junit.framework.TestCase.*;


import com.apicliente.domain.Cliente;
import com.apicliente.domain.ClienteService;

@SpringBootTest
class ApiclienteApplicationTests {
	
	
	@Autowired
	private ClienteService service;
	@Test
	public void test1() {
		Cliente cliente = new Cliente();
		cliente.setNome("Elza");
		cliente.setNumeroconta((long) 966);
		service.insert(cliente);
	}

	@Test
	void contextLoads() {
	}

}
