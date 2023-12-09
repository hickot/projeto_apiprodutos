package br.com.cotiinformatica.domain.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_categoria")
@Data
public class Categoria {

	@Id
	@Column(name = "id_pk")
	private UUID id;
	
	@Column(name = "nome", length = 50, nullable = false, unique = true)
	private String nome;
	
	//1 categoria para muitos produtos
	@OneToMany(mappedBy = "categoria")
	private List<Produto> produtos;
}
