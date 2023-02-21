package br.com.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.model.Pedido;
import br.com.delivery.model.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	Pedido findByNumero(String numero);
	
	List<Pedido> findByStatus(StatusPedido status);
}
