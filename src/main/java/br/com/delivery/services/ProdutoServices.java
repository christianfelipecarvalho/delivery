package br.com.delivery.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.exceptions.FormatoIncorretoDeDadoException;
import br.com.delivery.exceptions.ResourceNotFoundException;
import br.com.delivery.model.Produto;
import br.com.delivery.repository.ProdutoRepository;

@Service
public class ProdutoServices {
	
	private Logger logger = Logger.getLogger(ProdutoServices.class.getName());
	
	@Autowired
	ProdutoRepository repository;
	
	public List<Produto> findAll() {

        logger.info("Todos os Produtos");

		return repository.findAll();		
	}
	
	public Produto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("não foi encontrado nenhum produto com o ID informado"));
	}
	

	public Produto create(Produto produto) {
		return repository.save(produto);
	}
	
	public Produto update(Produto produto) {
		
		var entity = repository.findById(produto.getId()).orElseThrow(() -> new ResourceNotFoundException("não foi encontrado nenhum produto com o ID informado"));
	
		entity.setNome(produto.getNome());
		entity.setQuantidade(produto.getQuantidade());
		entity.setValor(produto.getValor());
		entity.setStatusProduto(produto.getStatusProduto());
		
		return repository.save(entity);
		
	}
	
	public void deletePedido(Long id) {
		
	}
	

}
