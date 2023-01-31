package br.com.delivery.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.delivery.exceptions.ResourceNotFoundException;
import br.com.delivery.mocks.ClienteMock;
import br.com.delivery.model.Cliente;
//import br.com.delivery.repository.ClienteRepository;

@Service
public class ClienteServices {

	private Logger logger = Logger.getLogger(ClienteServices.class.getName());
	
	
	//@Autowired
	//ClienteRepository repository;
	public List<Cliente> findAll(){
		List<Cliente> clientes = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			clientes.add(ClienteMock.criarMockdoCliente(Long.valueOf(i)));
		}
		logger.info("TOdos os clientes");
		
		//return repository.findAll();
		return clientes;
	}
	
	public Cliente findById(Long id) {
		Cliente cliente = ClienteMock.criarMockdoCliente(id);
		logger.info("Encontre um cliente!");
		
		return cliente;
		//return repository.findById(id)
				//.orElseThrow(() -> new ResourceNotFoundException("Nenhum cliente encontrado com esse Id!"));
	}
	
	
	public List<Cliente> findByNomeAndSobrenome(String nome, String sobrenome) {
		List<Cliente> clientes = new ArrayList<>();
		
		Cliente cliente1 = ClienteMock.criarMockdoCliente(1L);
		cliente1.setNome("jorge");
		cliente1.setSobrenome("costa");
		
		Cliente cliente2 = ClienteMock.criarMockdoCliente(2L);
		cliente2.setNome("christian");
		cliente2.setSobrenome("felipe");
		
		
		Cliente cliente3 = ClienteMock.criarMockdoCliente(3L);
		cliente3.setNome(nome);
		cliente3.setSobrenome(sobrenome);
		
		if (cliente1.getNome().equals(nome) && cliente1.getSobrenome().equals(sobrenome)) {
			clientes.add(cliente1);}
		
		
		if (cliente2.getNome().equals(nome) && cliente2.getSobrenome().equals(sobrenome)) {
			clientes.add(cliente2);}
		
		if (cliente3.getNome().equals(nome) && cliente3.getSobrenome().equals(sobrenome)) {
			clientes.add(cliente3);}
		
		return clientes;
	}
	
	public Cliente create(Cliente cliente) {
		
		logger.info("Um cliente criado!");
		
		//return repository.save(cliente);
		return cliente;
		
	}
	
	public Cliente update(Cliente cliente) {
		
		logger.info("Atualizando um cliente!");
		
		/*var entity = repository.findById(cliente.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado com esse ID!"));
		
		entity.setNome(cliente.getNome());
		entity.setSobrenome(cliente.getSobrenome());
		entity.setCpf(cliente.getCpf());
		entity.setRg(cliente.getRg());
		entity.setEmail(cliente.getEmail());*/
		//entity.setEndereco(cliente.getEndereco());
		
		
		//return repository.save(cliente);
		return cliente;
	}
	
	public void delete(Long id) {
		
	}
}
