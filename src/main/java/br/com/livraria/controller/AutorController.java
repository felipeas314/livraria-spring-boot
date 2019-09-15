package br.com.livraria.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.livraria.domain.Autor;
import br.com.livraria.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private AutorRepository autorRepository;

	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@PostMapping
	public ResponseEntity<Autor> adiciona(@Valid @RequestBody Autor autor, BindingResult bindingResult) {

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(autor.getId())
				.toUri();

		return ResponseEntity.created(location).body(autor);
	}

	@GetMapping("/lista/paginacao")
	public ResponseEntity<Page<Autor>> listaComPaginacao(@PageableDefault Pageable pageable) {
		return ResponseEntity.ok(autorRepository.findAll(pageable));
	}

	@GetMapping("/lista/todos")
	public ResponseEntity<List<Autor>> listaTodos() {
		return ResponseEntity.ok(autorRepository.findAll());
	}

	@GetMapping("/buscaporid/{id}")
	public ResponseEntity<Autor> buscaPorId(@PathVariable("id") Integer id) {
		return autorRepository.findById(id).map(categoria -> {
			return ResponseEntity.ok(categoria);
		}).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/atualiza/{id}")
	public ResponseEntity<Autor> atualiza(@RequestBody Autor autor, @PathVariable("id") Integer id) {
		return autorRepository.findById(id).map(a -> {

			a.setNome(autor.getNome());
			a.setSobre(autor.getSobre());
			a.setDataDeNascimento(autor.getDataDeNascimento());

			return ResponseEntity.ok(a);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/deleta/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") Integer id) {
		return autorRepository.findById(id).map(autor -> {
			autorRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
