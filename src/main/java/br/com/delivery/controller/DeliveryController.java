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
import br.com.delivery.model.StatusPedido;
import br.com.delivery.services.ClienteServices;
import br.com.delivery.services.PedidoServices;
import br.com.delivery.services.ProdutoServices;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

	@Autowired
	ClienteServices clienteServices;
	@Autowired
	PedidoServices pedidoServices;

	@Autowired
	ProdutoServices produtoServices;
	
	//PEDIDOS
	
	@GetMapping(value="/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> buscaPedidos(){
		return pedidoServices.findAll();
	}
	
	
	@GetMapping(value = "pedidos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pedido buscaPedidoPorId(@PathVariable(value="id") Long id) {
		
		return pedidoServices.findById(id);
	}

	@GetMapping(value = "pedidos/buscapornumero/{numero}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Pedido buscaPedidoPorNumero(@PathVariable(value="numero") String numero) {
		return pedidoServices.findByNumero(numero);
	}
	
	@GetMapping(value="pedidos/buscaporstatus/{status}")
	public List<Pedido> buscaPedidoPorStatus(@PathVariable(value="status") String status) {
		return pedidoServices.findByStatus(status);
	}
	
	@PostMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastraPedido(@RequestBody Pedido pedido) {
		pedidoServices.create(pedido);		
	}// cadastra um novo pedido, envia como parametro o pedido
	
	
	
	@PutMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alteraPedido(@RequestBody Pedido alteracaoPedido) {
		
	}
	
	@DeleteMapping(value="/pedidos/{id}")
	public void apagarPedido(@PathVariable(value="id") Long id) {
		
	}
	
	//CLIENTES
	
	@GetMapping(value="/clientes", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> buscaClientes() {
	 
		return clienteServices.findAll(); // busca todos os cliente da base de dados.
		
	}
	
	@GetMapping(value="/clientes/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Cliente buscaClientePorId(@PathVariable(value="id") Long id) {
		         
		
		return clienteServices.findById(id); //busca um cliente na base de acordo com o id informado.
	}
	
	//BUSCA POR NOME TESTAR NOVAMENTE 
	@GetMapping(value="/clientes/buscapornome/{nome}", produces=MediaType.APPLICATION_JSON_VALUE)//TESTAR BUSCAPORNOME
	public List<Cliente> buscaClientePorNome(@PathVariable(value="nome") String nome,
											@RequestParam(value="sobrenome", defaultValue="") String sobrenome) {
		
		return clienteServices.findByNome(nome, sobrenome);

	}

	// BUSCA POR CPF
	@GetMapping(value="/clientes/buscaporcpf/{cpf}", produces=MediaType.APPLICATION_JSON_VALUE) 
	public Cliente buscaClientePorCpf(@PathVariable(value="cpf") String cpf) {
		return clienteServices.findByCpf(cpf);
	}
	
	// BUSCA POR RG
	@GetMapping(value="/clientes/buscaporrg/{rg}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Cliente buscaClientePorRg(@PathVariable(value="rg") String rg) {
		return clienteServices.findByRg(rg);
	}
	
	//CADASTRACLIENTE
	@PostMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cliente cadastraCliente(@RequestBody Cliente cliente) {
		
		return clienteServices.create(cliente); //adiciona um novo cliente a base de dados.
	
	}
	 
	
	@PutMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cliente alteraCliente(@RequestBody Cliente cliente) {
		
		return clienteServices.update(cliente); //atualiza o cadastro de um cliente.
		
	}// altera o cadastro do cliente 
	
	
	@DeleteMapping(value="/clientes/{id}")
	public void apagarCliente(@PathVariable(value="id") Long id) {
		clienteServices.delete(id);  // apaga o cadastro de um cliente na base de dados.
	}
	
	
	
	
	//PRODUTOS
	
	// select de todos os produtos no banco 
	@GetMapping(value = "/produtos",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produto> buscaProdutos(){

		return produtoServices.findAll();
	}

	//Pesquisa por id
	@GetMapping(value="/produtos/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Produto buscaProdutoPorId(@PathVariable(value="id") Long id) {
		         
		
		return produtoServices.findById(id); //busca um cliente na base de acordo com o id informado.
	}
	
	@PostMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public Produto cadastraProduto(@RequestBody Produto produto) {

		return produtoServices.create(produto);

	}// cadastra um novo produto, envia como parametro o produto
	
	//Altera os dados de um produto
	@PutMapping( value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public Produto alteraProduto(@RequestBody Produto produto) {

		return produtoServices.update(produto);
	}
	
	@DeleteMapping(value="/produto/{id}")
	public void apagarProduto(@PathVariable(value="id") Long id) {
		clienteServices.delete(id);  // apaga o cadastro de um produto na base de dados.
	}
}
