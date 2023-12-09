package br.com.cotiinformatica.dtos;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProdutoPutDto {
	
	@NotNull(message = "Informe o id do produto desejado.")
	private UUID id;

	@Size(min = 8, max = 100, message = "Nome do produto deve ter de 8 a 100 caracteres.")
	@NotBlank(message = "Informe o nome do produto.")
	private String nome;

	@NotBlank(message = "Informe a descrição do produto.")
	private String descricao;

	@Min(value = 1, message = "Preço deve ser maior ou igual a 1.")
	private Double preco;

	@Min(value = 1, message = "Quantidade deve ser maior ou igual a 1.")
	private Integer quantidade;

	@NotNull(message = "ID da categoria é obrigatório.")
	private UUID idCategoria;

	@NotNull(message = "ID do fornecedor é obrigatório.")
	private UUID idFornecedor;
}
