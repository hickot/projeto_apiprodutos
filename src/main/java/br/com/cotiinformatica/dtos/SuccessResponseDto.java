package br.com.cotiinformatica.dtos;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class SuccessResponseDto {

	private HttpStatus status;
	private String message;

}
