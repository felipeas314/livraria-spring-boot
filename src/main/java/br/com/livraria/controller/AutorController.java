package br.com.livraria.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.livraria.domain.Autor;
import br.com.livraria.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private AutorRepository autorRepository;

	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@RequestMapping(method = RequestMethod.POST, value = "")
	public ResponseEntity<Autor> adiciona(@Valid @RequestBody Autor autor, BindingResult bindingResult) {
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/todos")
	public ResponseEntity<Page<Autor>> listaTodos(@PageableDefault Pageable pageable) {
		return ResponseEntity.ok(autorRepository.findAll(pageable));
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") Integer id) {
		return null;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "")
	public ResponseEntity<?> atualiza(@RequestBody Autor autor) {
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Integer id) {
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "")
	public ResponseEntity<?> listaComPaginacao() {
		return null;
	}

}
