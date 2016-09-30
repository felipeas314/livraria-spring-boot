package br.com.livraria.controllers;

import java.util.UUID;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.livraria.models.Categoria;
import br.com.livraria.services.CategoriaService;

@RestController
@RequestMapping("v1/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@RequestMapping(method = RequestMethod.POST, value = "")
	public ResponseEntity<?> adiciona(@RequestBody Categoria categoria) {
		return service.adiciona(categoria);
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
	public ResponseEntity<?> atualiza(@RequestBody Categoria categoria) {
		return service.atualiza(categoria);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") UUID id) {
		return service.remove(id);
	}
}
