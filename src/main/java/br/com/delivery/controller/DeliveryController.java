package br.com.delivery.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.delivery.model.Cliente;
import br.com.delivery.model.Pedido;
import br.com.delivery.model.Produto;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value =  "/pedido/{id}")
	public Long buscaPedidoPorId(@PathVariable(value="id") Long id) {
		
		return id; // adicionar o service da consulta pedido 
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/pedidos")
	public void buscaPedidos(){}
	// select de todos os pedidos no banco 
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE, value = "/cadastrapedido")
	public void cadastraPedido(@RequestBody Pedido pedido) {
		
	}// cadastra um novo pedido, envia como parametro o pedido
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE, value = "/alteraPedido")
	public void alteraPedido(@RequestBody Pedido alteracaoPedido) {
		
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE, value = "/cadastracliente")
	public void cadastraCliente(@RequestBody Cliente cliente) {
		
	}// cadastra um cliente 
	 
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE, value = "/alteracliente")
	public void alteraCliente(@RequestBody Cliente alteracaoCliente) {
		
	}// altera o cadastro do cliente 
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/produtos")
	public void buscaProdutos(){}
	// select de todos os produtos no banco 
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE, value = "/cadastraproduto")
	public void cadastraProduto(@RequestBody Produto produto) {
		
	}// cadastra um novo produto, envia como parametro o produto
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE, value = "/alteraproduto")
	public void alteraProduto(@RequestBody Produto alteracaoProduto) {
		
	}
	
	
}
