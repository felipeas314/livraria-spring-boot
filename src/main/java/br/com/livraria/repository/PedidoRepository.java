package br.com.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.livraria.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
