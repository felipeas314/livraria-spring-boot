package br.com.livraria.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.livraria.domain.Categoria;

@RestController
@RequestMapping("v1/categoria")
public class CategoriaController {

	@RequestMapping(method = RequestMethod.POST, value = "")
	public ResponseEntity<?> adiciona(@RequestBody Categoria categoria) {
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/todos")
	public ResponseEntity<?> listaTodos() {
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "")
	public ResponseEntity<?> listaComPaginacao() {
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") UUID id) {
		return null;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "")
	public ResponseEntity<?> atualiza(@RequestBody Categoria categoria) {
		return null;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") UUID id) {
		return null;
	}
}
