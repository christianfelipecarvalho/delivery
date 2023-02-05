package br.com.delivery.mocks;

import br.com.delivery.model.Pedido;
import br.com.delivery.model.StatusPedido;

public class PedidoMock {
	
	public static Pedido criarMockPedido(Long id) {
		Pedido pedido = new Pedido();
		pedido.setId(id);
		pedido.setNumero("123456");
		//pedido.setListaProduto(null);
		pedido.setQuantidadeProduto(4);
		pedido.setQuantidadeTotal(8);
		pedido.setStatus(StatusPedido.ABERTO);
		pedido.setValorTotal(100D);
		pedido.setDesconto(10D);
		
		
		return pedido;
	}

}
