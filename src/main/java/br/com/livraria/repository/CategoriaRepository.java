package br.com.livraria.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.livraria.models.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, UUID> {

}
