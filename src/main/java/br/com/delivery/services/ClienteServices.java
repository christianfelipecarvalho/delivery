package br.com.delivery.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.delivery.exceptions.FormatoIncorretoDeDadoException;
import br.com.delivery.exceptions.ResourceNotFoundException;
//
//import br.com.delivery.exceptions.ResourceNotFoundException;
import br.com.delivery.mocks.ClienteMock;
import br.com.delivery.model.Cliente;
import br.com.delivery.validadores.ValidadorFormatoCPF;
import br.com.delivery.validadores.ValidadorFormatoRg;
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
	
	
	public List<Cliente> findByNome(String nome, String sobrenome) {
		List<Cliente> clientesEncontrados = new ArrayList<>();
		List<Cliente> clientesCadastrados = new ArrayList<>();
	
		Cliente cliente1 = ClienteMock.criarMockdoCliente(1L);
		cliente1.setNome("jorge");
		cliente1.setSobrenome("costa");
		clientesCadastrados.add(cliente1);
		
		
		Cliente cliente2 = ClienteMock.criarMockdoCliente(2L);
		cliente2.setNome("jorge");
		cliente2.setSobrenome("felipe");
		clientesCadastrados.add(cliente2);
		
		Cliente cliente3 = ClienteMock.criarMockdoCliente(3L);
		cliente3.setNome("nathan");
		cliente3.setSobrenome("matheus");
		clientesCadastrados.add(cliente3);
		
		for (Cliente cliente: clientesCadastrados) {
			
			if (cliente.getNome().equals(nome) && cliente.getSobrenome().equals(sobrenome)) {
				clientesEncontrados.add(cliente);
				//Implementar select no banco por nome e sobrenome
			}
			
			else if(cliente.getNome().equals(nome) && sobrenome.equals("")) {
				clientesEncontrados.add(cliente);
				//Implementar select no banco por nome
			}
						
		}
		
		if (clientesEncontrados.size() == 0) {
			throw new ResourceNotFoundException("não foi encontrado nenhum cliente com o nome informado");
		}
		
		return clientesEncontrados;
	}
	
	public Cliente findByCpf(String cpf) {
		
		if (!ValidadorFormatoCPF.validarFormatoCPF(cpf)) {
			throw new FormatoIncorretoDeDadoException("O cpf informado deve estar no formato ***.***.***-**");
		}
		
		Cliente cliente = ClienteMock.criarMockdoCliente(1L);
		cliente.setCpf("123.456.789-10");
		
		if (!cpf.equals(cliente.getCpf())) {
			throw new ResourceNotFoundException("Não existe nenhum cadastro com este cpf");
		}
		
		
		return cliente;
	}
	
	public Cliente findByRg(String rg) {
		
		if (!ValidadorFormatoRg.validarFormatoRg(rg)) {
			throw new FormatoIncorretoDeDadoException("O rg informado deve estar no formato **.***.***-*");
		}
		
		
		Cliente cliente = ClienteMock.criarMockdoCliente(1L);
		cliente.setRg("12.345.789-1");
		
		if(!rg.equals(cliente.getRg())) {
			throw new ResourceNotFoundException("Não existe nenhum cadastro com o Rg informado");
		}
		
		return cliente;
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
