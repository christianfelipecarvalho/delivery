package br.com.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.delivery.model.Cliente;
import br.com.delivery.model.Pedido;
import br.com.delivery.model.Produto;
import br.com.delivery.services.ClienteServices;
import br.com.delivery.services.PedidoServices;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	ClienteServices clienteServices;
	@Autowired
	PedidoServices pedidoServices;
	
	//PEDIDOS
	
	@GetMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> buscaPedidos(){
		return pedidoServices.findAll();
	}
	
	
	
	@GetMapping(value =  "/buscapedidoporid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pedido buscaPedidoPorId(@PathVariable(value="id") Long id) {
		
		return pedidoServices.findById(id);// adicionar o service da consulta pedido 
	}

	@GetMapping(value="/buscapedidopornumero/{numero}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Pedido buscaPedidoPorNumero(@PathVariable(value="numero") String numero) {
		return pedidoServices.findByNumero(numero);
	}
	
	
	@PostMapping(value = "/cadastrapedido", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastraPedido(@RequestBody Pedido pedido) {
		
	}// cadastra um novo pedido, envia como parametro o pedido
	
	@PutMapping(value = "/alterapedido", produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alteraPedido(@RequestBody Pedido alteracaoPedido) {
		
	}
	
	@DeleteMapping(value="/apagarpedido/{id}")
	public void apagarPedido(@PathVariable(value="id") Long id) {
		
	}
	
	//CLIENTES
	
	@GetMapping(value="/clientes", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> buscaClientes() {
	 
		return clienteServices.findAll(); // busca todos os cliente da base de dados.
		
	}
	
	@GetMapping(value="/buscaclienteporid/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Cliente buscaClientePorId(@PathVariable(value="id") Long id) {
		         
		
		return clienteServices.findById(id); //busca um cliente na base de acordo com o id informado.
	}
	
	
	@GetMapping(value="/buscaclientepornome/{nome}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> buscaClientePorNome(@PathVariable(value="nome") String nome,
											@RequestParam(value="sobrenome", defaultValue="") String sobrenome) {
		
		return clienteServices.findByNome(nome, sobrenome);
	}
	
	@GetMapping(value="/buscaclienteporcpf/{cpf}", produces=MediaType.APPLICATION_JSON_VALUE) 
	public Cliente buscaClientePorCpf(@PathVariable(value="cpf") String cpf) {
		return clienteServices.findByCpf(cpf);
	}
	
	
	@GetMapping(value="/buscaclienteporrg/{rg}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Cliente buscaClientePorRg(@PathVariable(value="rg") String rg) {
		return clienteServices.findByRg(rg);
	}
	
	
	@PostMapping(value = "/cadastracliente", produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cliente cadastraCliente(@RequestBody Cliente cliente) {
		
		return clienteServices.create(cliente); //adiciona um novo cliente a base de dados.
	
	}
	 
	
	@PutMapping(value = "/alteracliente", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cliente alteraCliente(@RequestBody Cliente cliente) {
		
		return clienteServices.update(cliente); //atualiza o cadastro de um cliente.
		
	}// altera o cadastro do cliente 
	
	
	@DeleteMapping(value="/apagarcliente/{id}")
	public void apagarCliente(@PathVariable(value="id") Long id) {
		clienteServices.delete(id);  // apaga o cadastro de um cliente na base de dados.
	}
	
	
	
	
	//PRODUTOS
	

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
