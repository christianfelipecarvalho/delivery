package br.com.delivery.customVOsConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.delivery.customVOs.PedidoCustomVOV1;
import br.com.delivery.customVOs.PedidoCustomVOV2;
import br.com.delivery.customVOs.PedidoCustomVOV3;
import br.com.delivery.model.Pedido;
import br.com.delivery.utils.GeradorDateFormatado;

public class PedidoCustomVOConverter {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static Pedido PedidoVoToPedidoV1(PedidoCustomVOV1 pedidoVO) {
		
		
		Pedido pedido = new Pedido();
		
		pedido.setNumero(pedidoVO.getNumero());
		pedido.setDesconto(pedidoVO.getDesconto());
		pedido.setDataPedido(GeradorDateFormatado.gerarDateFormatado(pedidoVO.getDataPedido()));
		pedido.setQuantidadeProduto(pedidoVO.getQuantidadeProduto());
		pedido.setQuantidadeTotal(pedidoVO.getQuantidadeTotal());
		pedido.setStatus(pedidoVO.getStatus());
		pedido.setValorTotal(pedidoVO.getValorTotal());
		
		return pedido;
	}
	
	public static PedidoCustomVOV1 PedidoToPedidoVOV1(Pedido pedido) {
		
		PedidoCustomVOV1 pedidoVO = new PedidoCustomVOV1();
		
		pedidoVO.setNumero(pedido.getNumero());
		pedidoVO.setDesconto(pedido.getDesconto());
		pedidoVO.setDataPedido(sdf.format(pedido.getDataPedido()));
		pedidoVO.setQuantidadeProduto(pedido.getQuantidadeProduto());
		pedidoVO.setQuantidadeTotal(pedido.getQuantidadeTotal());
		pedidoVO.setStatus(pedido.getStatus());
		pedidoVO.setValorTotal(pedido.getValorTotal());
		pedidoVO.setCliente_id(pedido.getCliente().getId());
		
		return pedidoVO;
	}
	
	public static PedidoCustomVOV2 PedidoToPedidoVOV2(Pedido pedido) {
		PedidoCustomVOV2 pedidoVO = new PedidoCustomVOV2();
		
		pedidoVO.setId(pedido.getId());
		pedidoVO.setNumero(pedido.getNumero());
		pedidoVO.setDataPedido(sdf.format(pedido.getDataPedido()));
		pedidoVO.setDesconto(pedido.getDesconto());
		pedidoVO.setQuantidadeProduto(pedido.getQuantidadeProduto());
		pedidoVO.setQuantidadeTotal(pedido.getQuantidadeTotal());
		pedidoVO.setStatus(pedido.getStatus());
		pedidoVO.setValorTotal(pedido.getValorTotal());
		pedidoVO.setCliente_id(pedido.getCliente().getId());
		
		return pedidoVO;
	}
	
	public static PedidoCustomVOV3 PedidoToPedidoVOV3(Pedido pedido) {
		PedidoCustomVOV3 pedidoVO = new PedidoCustomVOV3();
		
		pedidoVO.setId(pedido.getId());
		pedidoVO.setNumero(pedido.getNumero());
		pedidoVO.setDesconto(pedido.getDesconto());
		pedidoVO.setDataPedido(sdf.format(pedido.getDataPedido()));
		pedidoVO.setQuantidadeProduto(pedido.getQuantidadeProduto());
		pedidoVO.setQuantidadeTotal(pedido.getQuantidadeTotal());
		pedidoVO.setStatus(pedido.getStatus());
		pedidoVO.setValorTotal(pedido.getValorTotal());
		
		
		return pedidoVO;
	}
	
	public static List<PedidoCustomVOV1> PedidosToPedidosVOV1(List<Pedido> pedidos) {
		List<PedidoCustomVOV1> pedidosVO = new ArrayList<>();
		
		for (Pedido pedido: pedidos) {	
			pedidosVO.add(PedidoToPedidoVOV1(pedido));
			
			
		}
		
		return pedidosVO;
	}
	
	public static List<PedidoCustomVOV2> PedidosToPedidosVOV2(List<Pedido> pedidos) {
		List<PedidoCustomVOV2> pedidosVO = new ArrayList<>();
		
		for (Pedido pedido: pedidos) {	
			pedidosVO.add(PedidoToPedidoVOV2(pedido));
			
			
		}
		
		return pedidosVO;
	}
	public static List<PedidoCustomVOV3> PedidosToPedidosVOV3(List<Pedido> pedidos) {
		List<PedidoCustomVOV3> pedidosVO = new ArrayList<>();
		
		for (Pedido pedido: pedidos) {	
			pedidosVO.add(PedidoToPedidoVOV3(pedido));
			
			
		}
		
		return pedidosVO;
	}
	
	
	
	public static Pedido PedidoVoUpdateToPedido(PedidoCustomVOV2 pedidoVO) {
		Pedido pedido = new Pedido();
		
		pedido.setId(pedidoVO.getId());
		pedido.setNumero(pedidoVO.getNumero());
		pedido.setDesconto(pedidoVO.getDesconto());
		pedido.setDataPedido(GeradorDateFormatado.gerarDateFormatado(pedidoVO.getDataPedido()));
		pedido.setQuantidadeProduto(pedidoVO.getQuantidadeProduto());
		pedido.setQuantidadeTotal(pedidoVO.getQuantidadeTotal());
		pedido.setStatus(pedidoVO.getStatus());
		pedido.setValorTotal(pedidoVO.getValorTotal());
		
		return pedido;
	}


}
