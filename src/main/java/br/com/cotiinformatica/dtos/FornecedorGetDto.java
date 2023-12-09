package br.com.cotiinformatica.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class FornecedorGetDto {

	private UUID id;
	private String nome;
	private String cnpj;
}
