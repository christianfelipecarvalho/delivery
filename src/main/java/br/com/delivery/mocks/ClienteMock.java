package br.com.delivery.mocks;

//import java.util.ArrayList;
//import java.util.List;

import br.com.delivery.model.Cliente;

public class ClienteMock {
	
	public static Cliente criarMockdoCliente(Long i) {
		Cliente cliente = new Cliente();
		cliente.setCpf("cpf do cliente " + i);
		cliente.setEmail("e-mail do cliente " + i);
		cliente.setEndereco("endereço do cliente " + i);
		cliente.setId(i);
		cliente.setNome("cliente " + i);
		cliente.setRg("rg do cliente " + i);
		cliente.setSobrenome("sobrenome do cliente " + 1);
		
		return cliente;
	}
	

	

}
