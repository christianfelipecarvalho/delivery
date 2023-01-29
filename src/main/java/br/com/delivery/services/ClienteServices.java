package br.com.delivery.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.delivery.exceptions.ResourceNotFoundException;
import br.com.delivery.model.Cliente;
import br.com.delivery.repository.ClienteRepository;

@Service
public class ClienteServices {

	private Logger logger = Logger.getLogger(ClienteServices.class.getName());
	
	
	@Autowired
	ClienteRepository repository;
	public List<Cliente> findAll(){
		
		logger.info("TOdos os clientes");
		
		return repository.findAll();
	}
	
	public Cliente findById(Long id) {
		
		logger.info("Encontre um cliente!");
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum cliente encontrado com esse Id!"));
	}
	
	public Cliente create(Cliente cliente) {
		
		logger.info("Um cliente criado!");
		
		return repository.save(cliente);
	}
	
	public Cliente Update(Cliente cliente) {
		
		logger.info("Atualizando um cliente!");
		
		var entity = repository.findById(cliente.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado com esse ID!"));
		
		entity.setNome(cliente.getNome());
		entity.setSobrenome(cliente.getSobrenome());
		entity.setCpf(cliente.getCpf());
		entity.setRg(cliente.getRg());
		entity.setEmail(cliente.getEmail());
		entity.setEndereco(cliente.getEndereco());
		
		
		return repository.save(cliente);
	}
}
