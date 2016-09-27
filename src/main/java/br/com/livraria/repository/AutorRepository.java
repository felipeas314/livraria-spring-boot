package br.com.livraria.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.livraria.models.Autor;

public interface AutorRepository extends CrudRepository<Autor, Integer> {

	Autor findByNome(String nome);

}
