package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.entities.Produto;
import br.com.cotiinformatica.domain.interfaces.ProdutoService;
import br.com.cotiinformatica.dtos.ProdutoGetDto;
import br.com.cotiinformatica.dtos.ProdutoPostDto;
import br.com.cotiinformatica.dtos.ProdutoPutDto;
import br.com.cotiinformatica.dtos.SuccessResponseDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutosController {

	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	ModelMapper modelMapper;

	@PostMapping
	public ResponseEntity<SuccessResponseDto> post(@RequestBody @Valid ProdutoPostDto dto) throws Exception {

		// enviando o DTO para a camada de domínio
		produtoService.create(dto);

		// criando a resposta de sucesso
		SuccessResponseDto response = new SuccessResponseDto();
		response.setStatus(HttpStatus.CREATED);
		response.setMessage("Produto cadastrado com sucesso.");

		// devolvendo a resposta
		return ResponseEntity.status(201).body(response);
	}

	@PutMapping
	public ResponseEntity<SuccessResponseDto> put(@RequestBody @Valid ProdutoPutDto dto) throws Exception {

		// enviando o DTO para a camada de domínio
		produtoService.update(dto);

		// criando a resposta de sucesso
		SuccessResponseDto response = new SuccessResponseDto();
		response.setStatus(HttpStatus.OK);
		response.setMessage("Produto atualizado com sucesso.");

		return ResponseEntity.status(200).body(response);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<SuccessResponseDto> delete(@PathVariable("id") UUID id) throws Exception {

		// enviando o id para camada de domínio excluir o produto
		produtoService.delete(id);

		// criando a resposta de sucesso
		SuccessResponseDto response = new SuccessResponseDto();
		response.setStatus(HttpStatus.OK);
		response.setMessage("Produto excluído com sucesso.");

		return ResponseEntity.status(200).body(response);
	}

	@GetMapping
	public List<ProdutoGetDto> getAll() throws Exception {

		//consultar todos os produtos no banco de dados
		List<Produto> produtos = produtoService.findAll();
		
		//copiar os dados dos produtos para uma lista da classe ProdutoGetDto
		List<ProdutoGetDto> result = modelMapper.map(produtos, 
				new TypeToken<List<ProdutoGetDto>>() {}.getType());
		
		//retornando os dados
		return result;
	}
}
