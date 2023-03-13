package br.com.delivery.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "pedido")
//@JsonPropertyOrder({"id", "numero", "quantidadeProduto", "quantidadeTotal", "desconto", "valorTotal", "status", "cliente_id"})
public class Pedido implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String numero;
	
	@Column(name="data")
	private Date dataPedido;
	
	//@Column
	//private List<Produto> listaProduto;
	
	@Column
	private Integer quantidadeProduto;
	
	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	@Column
	private Integer quantidadeTotal;
	
	@Column
	private Double desconto;
	
	@Column
	private Double valorTotal;
	
	@Column 
	private StatusPedido status;
	
	@OneToOne(targetEntity=Cliente.class)
	@JoinColumn(name="cliente_id", foreignKey = @ForeignKey(name="cliente_id"))
	private Cliente cliente;
	
	
	
	//@ManyToMany()
	//@JoinTable(name="pedido_itens", 
				//joinColumns= {@JoinColumn(name="pedido_id")}, inverseJoinColumns= {@JoinColumn(name="produto_id")} )
	//private List<Produto> produtos;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	//public List<Produto> getListaProduto() {
		//return listaProduto;
	//}

	//public void setListaProduto(List<Produto> listaProduto) {
		//this.listaProduto = listaProduto;
	//}

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
	
}
