package br.com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	

}
