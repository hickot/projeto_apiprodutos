package br.com.cotiinformatica.domain.interfaces;

import java.util.List;

import br.com.cotiinformatica.domain.entities.Fornecedor;

public interface FornecedorService {

	List<Fornecedor> findAll() throws Exception;
}
