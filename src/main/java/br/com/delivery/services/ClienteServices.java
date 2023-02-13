package br.com.delivery.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.exceptions.FormatoIncorretoDeDadoException;
import br.com.delivery.exceptions.ResourceFoundException;
import br.com.delivery.exceptions.ResourceNotFoundException;
import br.com.delivery.model.Cliente;
import br.com.delivery.repository.ClienteRepository;
import br.com.delivery.validadores.ValidadorFormatoCPF;
import br.com.delivery.validadores.ValidadorFormatoRg;

@Service
public class ClienteServices {

	private Logger logger = Logger.getLogger(ClienteServices.class.getName());
	
	
	@Autowired
	ClienteRepository repository;
	
	public List<Cliente> findAll(){
		
		logger.info("Todos os clientes");
		
		return repository.findAll();
	}
	
	public Cliente findById(Long id) {
		logger.info("Encontre um cliente!");
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum cliente encontrado com esse Id!"));
	}
	
	
	public List<Cliente> findByNome(String nome, String sobrenome) {
		List<Cliente> clientes = new ArrayList<>();
		
		if (sobrenome.length() > 0) {
			clientes = repository.findByNomeAndSobrenome(nome, sobrenome);
		}
		
		else {
			clientes = repository.findByNome(nome);
		}
		
		
		if (clientes.size() == 0) {
			throw new ResourceNotFoundException("Não foi encontrado nenhum cliente com o nome fornecido");
		}
		
		return clientes;
	}
	
	public Cliente findByCpf(String cpf) {
		
		if (!ValidadorFormatoCPF.validarFormatoCPF(cpf)) {
			throw new FormatoIncorretoDeDadoException("O cpf informado deve estar no formato ***.***.***-**");
		}
		
		Cliente cliente = repository.findByCpf(cpf);
		
		
		if (cliente == null) {
			throw new ResourceNotFoundException("não existe nenhum cliente com este cpf");
		}
		
		return cliente;
	}
	
	public Cliente findByRg(String rg) {
		
		if (!ValidadorFormatoRg.validarFormatoRg(rg)) {
			throw new FormatoIncorretoDeDadoException("O rg informado deve estar no formato **.***.***-*");}
		
		Cliente cliente = repository.findByRg(rg);
		
		if (cliente == null) {
			throw new ResourceNotFoundException("Não há nenhum cadastro com este rg, tente novamente");
		}
		
		return cliente;
		
		
		}
	
	
	public Cliente create(Cliente cliente) {
		
		Boolean formatoCorretoRg = ValidadorFormatoRg.validarFormatoRg(cliente.getRg());
		Boolean formatoCorretoCpf = ValidadorFormatoCPF.validarFormatoCPF(cliente.getCpf());
		
		if (formatoCorretoRg == false && formatoCorretoCpf == false) {
			throw new FormatoIncorretoDeDadoException("O Rg e o Cpf informados estão no formato incorreto");
		}
		
		else if (formatoCorretoRg == false) {
			throw new FormatoIncorretoDeDadoException("O Rg informado esta no formato incorreto");
		}
		
		else if (formatoCorretoCpf == false) {
			throw new FormatoIncorretoDeDadoException("O Cpf informado esta no formato incorreto");
		}
		
		
		Cliente clienteBuscadoPorCpf = repository.findByCpf(cliente.getCpf());
		Cliente clienteBuscadoPorRg = repository.findByRg(cliente.getRg());
		
		if (clienteBuscadoPorCpf != null && clienteBuscadoPorRg != null) {
			throw new ResourceFoundException("Já existe um cadastro com o cpf e rg informados");
			
		}
		
		else if (clienteBuscadoPorCpf != null) {
			throw new ResourceFoundException("Já existe um cadastro com o cpf informado");
			
		}
		
		else if (clienteBuscadoPorRg != null) {
			throw new ResourceFoundException("Já existe um cadastro com o rg informado");
			
		}
		
		logger.info("cadastrando um cliente..");
		return repository.save(cliente);
	}
	
	public Cliente update(Cliente cliente) {
		
		Boolean formatoCorretoRg = ValidadorFormatoRg.validarFormatoRg(cliente.getRg());
		Boolean formatoCorretoCpf = ValidadorFormatoCPF.validarFormatoCPF(cliente.getCpf());
		
		if (formatoCorretoRg == false && formatoCorretoCpf == false) {
			throw new FormatoIncorretoDeDadoException("O Rg e o Cpf informados estão no formato incorreto");
		}
		
		else if (formatoCorretoRg == false) {
			throw new FormatoIncorretoDeDadoException("O Rg informado esta no formato incorreto");
		}
		
		else if (formatoCorretoCpf == false) {
			throw new FormatoIncorretoDeDadoException("O Cpf informado esta no formato incorreto");
		}
		
		
				
		Cliente clienteBuscadoPorRg = repository.findByRg(cliente.getRg());
		Cliente clienteBuscadoPorCpf = repository.findByCpf(cliente.getCpf());
		
		
		if (clienteBuscadoPorCpf != null && clienteBuscadoPorRg != null) {
			throw new ResourceFoundException("Já existe um cadastro com o cpf e rg informados");
			
		}
		
		else if (clienteBuscadoPorCpf != null) {
			throw new ResourceFoundException("Já existe um cadastro com o cpf informado");
			
		}
		
		else if (clienteBuscadoPorRg != null) {
			throw new ResourceFoundException("Já existe um cadastro com o rg informado");
			
		}
		
		var entity = repository.findById(cliente.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado com esse ID!"));
		
		
		Boolean CpfNaoCadastradoEdiferenteDoInformado = clienteBuscadoPorCpf != null && !cliente.getCpf().equals(entity.getCpf());
		Boolean RgNaoCadastradoEdiferenteDoInformado = clienteBuscadoPorRg != null && !cliente.getRg().equals(entity.getRg());
		
		if (CpfNaoCadastradoEdiferenteDoInformado && RgNaoCadastradoEdiferenteDoInformado) {
			throw new ResourceFoundException("já existem clientes cadastrados com o cpf e rg informados");
		}
		
		if (RgNaoCadastradoEdiferenteDoInformado) {
			throw new ResourceFoundException("Já existe um cliente cadastrado com este Rg");
		}
		
		else if(CpfNaoCadastradoEdiferenteDoInformado) {
			throw new ResourceFoundException("Já existe um cliente cadastrado com este Cpf");
			
		}
		
		entity.setNome(cliente.getNome());
		entity.setSobrenome(cliente.getSobrenome());
		entity.setCpf(cliente.getCpf());
		entity.setRg(cliente.getRg());
		entity.setEmail(cliente.getEmail());
		//entity.setEndereco(cliente.getEndereco());
	
		logger.info("Atualizando um cliente!");
		return repository.save(cliente);
	}
	
	public void delete(Long id) {
		
	}
}
