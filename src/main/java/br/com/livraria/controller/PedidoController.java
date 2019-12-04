package br.com.livraria.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.livraria.domain.Pedido;
import br.com.livraria.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	public PedidoController(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@PostMapping
	public ResponseEntity<Pedido> adiciona(@Valid @RequestBody Pedido pedido) {

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(pedido.getId())
				.toUri();

		return ResponseEntity.created(location).body(pedido);
	}

	@GetMapping("/lista/paginacao")
	public ResponseEntity<Page<Pedido>> listaComPaginacao(@PageableDefault Pageable pageable) {
		return ResponseEntity.ok(pedidoRepository.findAll(pageable));
	}

	@GetMapping("/lista/todos")
	public ResponseEntity<List<Pedido>> listaTodos() {
		return ResponseEntity.ok(pedidoRepository.findAll());
	}

	@GetMapping("/buscaporid/{id}")
	public ResponseEntity<Pedido> buscaPorId(@PathVariable("id") Integer id) {
		return pedidoRepository.findById(id).map(pedido -> {
			return ResponseEntity.ok(pedido);
		}).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/atualiza/{id}")
	public ResponseEntity<Pedido> atualiza(@RequestBody Pedido pedido, @PathVariable("id") Integer id) {
		return pedidoRepository.findById(id).map(p -> {
			
			p.setLivros(pedido.getLivros());
			
			return ResponseEntity.ok(p);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/deleta/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") Integer id) {
		return pedidoRepository.findById(id).map(pedido -> {
			pedidoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
