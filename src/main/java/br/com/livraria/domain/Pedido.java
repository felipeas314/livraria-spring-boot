package br.com.livraria.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany
	private List<Livro> livros;

	private BigDecimal precoTotal;

	private LocalDateTime dataDoPedido;
	
	@Embedded
	private Endereco endereco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public LocalDateTime getDataDoPedido() {
		return dataDoPedido;
	}

	public void setDataDoPedido(LocalDateTime dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}

	public BigDecimal calculaPrecoDoPedido() {
		return livros.stream().map(Livro::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
