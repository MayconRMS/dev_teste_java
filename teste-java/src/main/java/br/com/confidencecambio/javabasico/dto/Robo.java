package br.com.confidencecambio.javabasico.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Robo extends NomePersonalizado {

	@NotBlank(message = "Nome não pode ser nulo")
	@Size(min = 1, message = "Nome deve ter mais de 1 caracter")
	private String nome;

}
