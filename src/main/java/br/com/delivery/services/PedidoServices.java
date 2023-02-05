package br.com.delivery.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.delivery.exceptions.ResourceNotFoundException;
import br.com.delivery.mocks.PedidoMock;
import br.com.delivery.model.Pedido;

@Service
public class PedidoServices {
	
	private Logger logger = Logger.getLogger(PedidoServices.class.getName());
	
	public List<Pedido> findAll() {
		List<Pedido> pedidos = new ArrayList<>();
		
		
		for (int i = 0; i < 5; i++) {
			pedidos.add(PedidoMock.criarMockPedido(Long.valueOf(i)));
		}
		
		return pedidos;
	}
	
	public Pedido findById(Long id) {
		Pedido pedido = PedidoMock.criarMockPedido(1L);
		
		if (id != pedido.getId()) {
			throw new ResourceNotFoundException("não existe nenhum pedido com este id");
		}
		
		return pedido;
	}
	
	public Pedido findByNumero(String numero) {
		Pedido pedido = PedidoMock.criarMockPedido(1L);
		
		if (!numero.equals(pedido.getNumero())) {
			throw new ResourceNotFoundException("não existe nenhum pedido com este número");
		}
		
		return pedido;
	}
	
	public List<Pedido> findByStatus(String status) {
		List<Pedido> pedidos = new ArrayList<>();
		
		return pedidos;
		
	}
	
	public Pedido create(Pedido pedido) {
		return pedido;
	}
	
	public Pedido update(Pedido pedido) {
		return pedido;
	}
	
	public void deletePedido(Long id) {
		
	}
	

}
