package br.com.cotiinformatica.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.entities.Fornecedor;
import br.com.cotiinformatica.domain.interfaces.FornecedorService;
import br.com.cotiinformatica.repositories.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService {

	@Autowired
	FornecedorRepository fornecedorRepository;

	@Override
	public List<Fornecedor> findAll() throws Exception {
		// Consultar todos os fornecedores cadastrados na base de dados
		return (List<Fornecedor>) fornecedorRepository.findAll();
	}	
}
