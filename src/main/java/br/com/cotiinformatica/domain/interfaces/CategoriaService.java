package br.com.cotiinformatica.domain.interfaces;

import java.util.List;

import br.com.cotiinformatica.domain.entities.Categoria;

public interface CategoriaService {

	List<Categoria> findAll() throws Exception;	
}
