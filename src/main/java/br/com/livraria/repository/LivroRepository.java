package br.com.livraria.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.livraria.domain.Livro;

public interface LivroRepository extends CrudRepository<Livro, UUID> {

}
