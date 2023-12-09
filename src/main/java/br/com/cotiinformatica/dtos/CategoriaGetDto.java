package br.com.cotiinformatica.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class CategoriaGetDto {

	private UUID id;
	private String nome;
}
