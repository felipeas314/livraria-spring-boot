package br.com.livraria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.livraria.models.Autor;
import br.com.livraria.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repository;

	private ResponseEntity<?> response;

	public ResponseEntity<?> adiciona(Autor autor) {
		try {
			repository.save(autor);
			response = new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			response = new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return response;
	}

	public ResponseEntity<?> buscaPorId(Integer id) {
		try {
			Autor autor = repository.findOne(id);
			response = new ResponseEntity<Autor>(autor, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	public ResponseEntity<?> listaTodos() {
		try {
			response = new ResponseEntity<Iterable<Autor>>(repository.findAll(), HttpStatus.OK);
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

	public ResponseEntity<?> atualiza(Autor autor) {
		try {
			repository.save(autor);
			response = new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	public ResponseEntity<?> remove(Integer id) {
		try {
			repository.delete(id);
			response = new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	public ResponseEntity<?> buscaPorNome(String nome) {
		try {
			Autor autor = repository.findByNome(nome);
			response = new ResponseEntity<Autor>(autor, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
