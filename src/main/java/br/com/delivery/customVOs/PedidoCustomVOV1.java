package br.com.delivery.customVOs;

import java.io.Serializable;
import java.util.Date;

import br.com.delivery.model.StatusPedido;

public class PedidoCustomVOV1 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private String numero;
	
	//@Column
	//private List<Produto> listaProduto;
	
	private String dataPedido;
	
	private Integer quantidadeProduto;
	
	private Integer quantidadeTotal;
	
	private Double desconto;
	
	private Double valorTotal;
	
	private StatusPedido status;

	private Long cliente_id;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Integer getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void setQuantidadeTotal(Integer quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Long getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	
	
	
}
