package br.com.cotiinformatica.domain.entities;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_produto")
@Data
public class Produto {

	@Id
	@Column(name = "id_pk")
	private UUID id;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "descricao", length = 500, nullable = false)
	private String descricao;

	@Column(name = "preco", precision = 10, scale = 2, nullable = false)
	private BigDecimal preco;

	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	@ManyToOne //muitos produtos para 1 categoria
	@JoinColumn(name = "categoria_id_fk", nullable = false)
	private Categoria categoria;

	@ManyToOne //muitos produtos para 1 fornecedor
	@JoinColumn(name = "fornecedor_id_fk", nullable = false)
	private Fornecedor fornecedor;
}



