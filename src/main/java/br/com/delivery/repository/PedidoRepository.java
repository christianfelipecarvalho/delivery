package br.com.delivery.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.delivery.model.Pedido;
import br.com.delivery.model.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	Pedido findByNumero(String numero);
	
	List<Pedido> findByStatus(StatusPedido status);
	
	@Query(value="select * from pedido where cliente_id = :id", nativeQuery=true)
	List<Pedido> findPedidoByClienteId(Long id);
	
	List<Pedido> findByDataPedido(Date dataPedido);
	
}
