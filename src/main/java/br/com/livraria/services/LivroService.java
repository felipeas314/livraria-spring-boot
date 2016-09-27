package br.com.livraria.services;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.livraria.models.Categoria;
import br.com.livraria.models.Livro;
import br.com.livraria.repository.LivroRepository;

@Service
public class LivroService {

	private LivroRepository repository;

	private ResponseEntity<?> response;

	public ResponseEntity<?> adiciona(Livro livro) {
		try {
			repository.save(livro);
			response = new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			response = new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return response;
	}

	public ResponseEntity<?> buscaPorId(UUID id) {
		try {
			Livro livro = repository.findOne(id);
			response = new ResponseEntity<Livro>(livro, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	public ResponseEntity<?> listaTodos() {
		try {
			response = new ResponseEntity<Iterable<Livro>>(repository.findAll(), HttpStatus.OK);
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

	public ResponseEntity<?> atualiza(Livro livro) {
		try {
			repository.save(livro);
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
