package br.com.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	
	Cliente findByCpf(String cpf);
	
	Cliente findByRg(String rg);
	
	List<Cliente> findByNome(String nome);
	
	List<Cliente> findByNomeAndSobrenome(String nome, String Sobrenome);
}
