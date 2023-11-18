package br.com.cotiinformatica.domain.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.entities.Categoria;
import br.com.cotiinformatica.domain.entities.Fornecedor;
import br.com.cotiinformatica.domain.entities.Produto;
import br.com.cotiinformatica.domain.interfaces.ProdutoService;
import br.com.cotiinformatica.dtos.ProdutoPostDto;
import br.com.cotiinformatica.repositories.CategoriaRepository;
import br.com.cotiinformatica.repositories.FornecedorRepository;
import br.com.cotiinformatica.repositories.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public void create(ProdutoPostDto dto) throws Exception {
		
		//verificar se o fornecedor informado existe no banco de dados
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(dto.getIdFornecedor());
		
		//buscando a categoria no banco de dados
		Optional<Categoria> categoria = categoriaRepository.findById(dto.getIdCategoria());
		
		//verificando se o forncedor não foi encontrado
		if(fornecedor.isEmpty()) {
			
			throw new IllegalArgumentException("Erro. O fornecedor informado não existe");
		}
		
		//verificando se a categoria não foi encontrado
		if(categoria.isEmpty()) {
			
			throw new IllegalArgumentException("Erro. A categoria informada não existe");
		}
		
		//preencher os dados do produto
		Produto produto = new Produto();
		
		produto.setId(UUID.randomUUID());
		produto.setNome(dto.getNome());
		produto.setPreco(new BigDecimal(dto.getPreco()));
		produto.setQuantidade(dto.getQuantidade());
		produto.setDescricao(dto.getDescricao());
		produto.setFornecedor(fornecedor.get());
		produto.setCategoria(categoria.get());
		
		//gravar no banco de dados
		produtoRepository.save(produto);
	}

	@Override
	public void update(Produto produto) throws Exception {
		produtoRepository.save(produto);
	}

	@Override
	public void delete(UUID id) throws Exception {
		Produto produto = findById(id);
		produtoRepository.delete(produto);
	}

	@Override
	public List<Produto> findAll() throws Exception {
		return (List<Produto>) produtoRepository.findAll();
	}

	@Override
	public Produto findById(UUID id) throws Exception {
		return produtoRepository.findById(id).get();
	}
}
