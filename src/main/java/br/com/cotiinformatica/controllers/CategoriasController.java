package br.com.cotiinformatica.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriasController {
	
	@GetMapping
	public void getAll() {
		//TODO
	}
}
