package br.com.delivery.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.customVOs.PedidoCustomVOV1;
import br.com.delivery.customVOs.PedidoCustomVOV2;
import br.com.delivery.customVOs.PedidoCustomVOV3;
import br.com.delivery.customVOsConverter.PedidoCustomVOConverter;
import br.com.delivery.exceptions.FormatoIncorretoDeDadoException;
import br.com.delivery.exceptions.ResourceNotFoundException;
import br.com.delivery.model.Pedido;
import br.com.delivery.model.StatusPedido;
import br.com.delivery.repository.PedidoRepository;
import br.com.delivery.utils.GeradorDateFormatado;

@Service
public class PedidoServices {
	
	private Logger logger = Logger.getLogger(PedidoServices.class.getName());
	
	@Autowired
	PedidoRepository repository;
	
	public List<PedidoCustomVOV1> findAll() {
		return PedidoCustomVOConverter.PedidosToPedidosVOV1(repository.findAll());		
	}
	
	public PedidoCustomVOV1 findById(Long id) {
		Pedido pedido = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("não foi encontrado nenhum pedido com o ID informado"));
	
		return PedidoCustomVOConverter.PedidoToPedidoVOV1(pedido);
	}

	public PedidoCustomVOV1 findByNumero(String numero) {
		Pedido pedido = repository.findByNumero(numero);
		
		if (pedido == null) {
			throw new ResourceNotFoundException("não existe nenhum pedido com o número informado");
		}
		
		return PedidoCustomVOConverter.PedidoToPedidoVOV1(pedido);
	}
	
	public List<PedidoCustomVOV1> findByStatus(String status) {
		
		if (!status.equals("ABERTO") && !status.equals("CONCLUIDO") && !status.equals("CANCELADO")) {
			throw new FormatoIncorretoDeDadoException("O status informado deve ser ABERTO, CONCLUIDO ou CANCELADO");
		}
		
		List<Pedido> pedidos = repository.findByStatus(StatusPedido.getStatusPedidoByString(status));
		
		
		if (pedidos.size() == 0) {
			throw new ResourceNotFoundException("não existem pedidos cadastrados com o Status informado");
		}
		
		return PedidoCustomVOConverter.PedidosToPedidosVOV1(pedidos);
		
	}
	
	public List<PedidoCustomVOV3> findPedidosByClienteID(Long clienteID) {
		List<Pedido> pedidos = repository.findPedidoByClienteId(clienteID);
		
		return PedidoCustomVOConverter.PedidosToPedidosVOV3(pedidos);
	}
	
	public List<PedidoCustomVOV2> findPedidosBydataPedido(Integer dia, Integer mes, Integer ano){
		
		Date data = Date.from(LocalDate.of(ano, mes, dia).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		List<Pedido> pedidos = repository.findByDataPedido(data);
		
		return PedidoCustomVOConverter.PedidosToPedidosVOV2(pedidos);
	}
	
	public Pedido create(Pedido pedido) {
		return repository.save(pedido);
	}
	
	public Pedido update(Pedido pedido) {
		
		var entity = repository.findById(pedido.getId()).orElseThrow(() -> new ResourceNotFoundException("não foi encontrado nenhum pedido com o ID informado"));
	
		entity.setNumero(pedido.getNumero());
		entity.setDesconto(pedido.getDesconto());
		//entity.setListaProduto(pedido.getListaProduto());
		entity.setDataPedido(pedido.getDataPedido());
		entity.setQuantidadeProduto(pedido.getQuantidadeProduto());
		entity.setQuantidadeTotal(pedido.getQuantidadeTotal());
		entity.setStatus(pedido.getStatus());
		entity.setValorTotal(pedido.getValorTotal());
		entity.setCliente(pedido.getCliente());
		
		return repository.save(entity);
		
	}
	
	public void deletePedido(Long id) {
		
	}
	

}
