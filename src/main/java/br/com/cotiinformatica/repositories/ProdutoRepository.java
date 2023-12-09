package br.com.cotiinformatica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cotiinformatica.domain.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

}
