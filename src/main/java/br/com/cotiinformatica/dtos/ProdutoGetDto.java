package br.com.cotiinformatica.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class ProdutoGetDto {

	private UUID id;
	private String nome;
	private String descricao;
	private Double preco;
	private Integer quantidade;
	private CategoriaGetDto categoria;
	private FornecedorGetDto fornecedor;
}
