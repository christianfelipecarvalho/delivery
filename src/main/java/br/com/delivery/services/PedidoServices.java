package br.com.delivery.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.exceptions.FormatoIncorretoDeDadoException;
import br.com.delivery.exceptions.ResourceNotFoundException;
import br.com.delivery.model.Pedido;
import br.com.delivery.model.StatusPedido;
import br.com.delivery.repository.PedidoRepository;

@Service
public class PedidoServices {
	
	private Logger logger = Logger.getLogger(PedidoServices.class.getName());
	
	@Autowired
	PedidoRepository repository;
	
	public List<Pedido> findAll() {
		return repository.findAll();		
	}
	
	public Pedido findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("não foi encontrado nenhum pedido com o ID informado"));
	}

	public Pedido findByNumero(String numero) {
		Pedido pedido = repository.findByNumero(numero);
		
		if (pedido == null) {
			throw new ResourceNotFoundException("não existe nenhum pedido com o número informado");
		}
		
		return pedido;
	}
	
	public List<Pedido> findByStatus(String status) {
		
		if (!status.equals("ABERTO") && !status.equals("CONCLUIDO") && !status.equals("CANCELADO")) {
			throw new FormatoIncorretoDeDadoException("O status informado deve ser ABERTO, CONCLUIDO ou CANCELADO");
		}
		
		List<Pedido> pedidos = repository.findByStatus(StatusPedido.getStatusPedidoByString(status));
		
		
		if (pedidos.size() == 0) {
			throw new ResourceNotFoundException("não existem pedidos cadastrados com o Status informado");
		}
		
		return pedidos;
		
	}
	
	public Pedido create(Pedido pedido) {
		return repository.save(pedido);
	}
	
	public Pedido update(Pedido pedido) {
		
		var entity = repository.findById(pedido.getId()).orElseThrow(() -> new ResourceNotFoundException("não foi encontrado nenhum pedido com o ID informado"));
	
		entity.setNumero(pedido.getNumero());
		entity.setDesconto(pedido.getDesconto());
		//entity.setListaProduto(pedido.getListaProduto());
		entity.setQuantidadeProduto(pedido.getQuantidadeProduto());
		entity.setQuantidadeTotal(pedido.getQuantidadeTotal());
		entity.setStatus(pedido.getStatus());
		entity.setValorTotal(pedido.getValorTotal());
		
		return repository.save(entity);
		
	}
	
	public void deletePedido(Long id) {
		
	}
	

}
