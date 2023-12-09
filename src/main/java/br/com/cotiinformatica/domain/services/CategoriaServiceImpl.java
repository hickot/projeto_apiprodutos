package br.com.cotiinformatica.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.entities.Categoria;
import br.com.cotiinformatica.domain.interfaces.CategoriaService;
import br.com.cotiinformatica.repositories.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> findAll() throws Exception {
		// retornar todas as categorias cadastradas
		return (List<Categoria>) categoriaRepository.findAll();
	}

}
