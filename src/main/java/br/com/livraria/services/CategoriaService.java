package br.com.livraria.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.livraria.models.Categoria;
import br.com.livraria.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;

	private ResponseEntity<?> response;

	public ResponseEntity<?> adiciona(Categoria categoria) {
		try {
			repository.save(categoria);
			response = new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			response = new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return response;
	}

	public ResponseEntity<?> buscaPorId(UUID id) {
		try {
			Categoria categoria = repository.findOne(id);
			response = new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	public ResponseEntity<?> listaTodos() {
		try {
			response = new ResponseEntity<Iterable<Categoria>>(repository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	public ResponseEntity<?> listaComPaginacao() {
		try {

		} catch (Exception e) {

		}
		return response;
	}

	public ResponseEntity<?> atualiza(Categoria categoria) {
		try {
			repository.save(categoria);
			response = new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	public ResponseEntity<?> remove(UUID id) {
		try {
			repository.delete(id);
			response = new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
