package br.com.cotiinformatica.domain.entities;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class Fornecedor {
	
	private UUID id;
	private String nome;
	private String cnpj;
	private List<Produto> produtos;
}
