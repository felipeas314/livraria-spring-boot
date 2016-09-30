package br.com.livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.livraria.models.Autor;
import br.com.livraria.services.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorService service;

	@RequestMapping(method = RequestMethod.POST, value = "")
	public ResponseEntity<?> adiciona(@RequestBody Autor autor, BindingResult bindingResult) {
		return service.adiciona(autor);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/todos")
	public ResponseEntity<?> listaTodos() {
		return service.listaTodos();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") Integer id) {
		return service.remove(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "")
	public ResponseEntity<?> atualiza(@RequestBody Autor autor) {
		return service.atualiza(autor);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Integer id) {
		return service.buscaPorId(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "")
	public ResponseEntity<?> listaComPaginacao() {
		return service.listaComPaginacao();
	}

}
