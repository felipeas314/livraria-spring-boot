package br.com.livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.livraria.models.Autor;
import br.com.livraria.services.AutorService;

@Controller
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorService service;

	@RequestMapping(method = RequestMethod.POST, value = "")
	@ResponseBody
	public ResponseEntity<?> adiciona(@RequestBody Autor autor, BindingResult bindingResult) {
		return service.adiciona(autor);
	}

	@RequestMapping(method = RequestMethod.GET, value = "")
	public ResponseEntity<?> lista() {
		return service.listaTodos();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/nome")
	@ResponseBody
	public ResponseEntity<?> buscaPorEmail() {
		return service.buscaPorNome("felipe");
	}

}
