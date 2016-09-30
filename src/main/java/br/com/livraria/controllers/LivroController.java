package br.com.livraria.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.livraria.models.Livro;
import br.com.livraria.services.LivroService;

@RestController
@RequestMapping("v1/livro")
public class LivroController {

	@Autowired
	private LivroService service;

	@RequestMapping(method = RequestMethod.POST, value = "")
	public ResponseEntity<?> adiciona(@RequestBody Livro livro) {
		return service.adiciona(livro);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/todos")
	public ResponseEntity<?> listaTodos() {
		return service.listaTodos();
	}

	@RequestMapping(method = RequestMethod.GET, value = "")
	public ResponseEntity<?> listaComPaginacao() {
		return service.listaComPaginacao();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") UUID id) {
		return service.buscaPorId(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "")
	public ResponseEntity<?> atualiza(@RequestBody Livro livro) {
		return service.atualiza(livro);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") UUID id) {
		return service.remove(id);
	}
}
