package br.com.confidencecambio.javabasico.service;

import java.util.Optional;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import br.com.confidencecambio.javabasico.dto.request.DadosRequest;

@Service
public class HelloWorldService {

	private static final String valorPadrao = "Mundo";

	public String retornaValorValido(@Nullable String nome) {
		return Optional.ofNullable(nome).orElse(valorPadrao);
	}

	public Double retornaImc(DadosRequest imcDto) {
		return Double.valueOf(imcDto.getPeso() / (imcDto.getAltura() * imcDto.getAltura()));
	}

	public String retornaDescricaoImc(Double imc) {
		if (imc <= 18.5) {
			return "Sua Classificação é de Magreza";
		} else if (imc >= 18.5 && imc <= 24.9) {
			return "Sua Classificação Está Dentro do Normal";
		} else if (imc >= 25.0 && imc <= 29.9) {
			return "Sua Classificação é de Sobrepeso I";
		} else if (imc >= 30.0 && imc <= 39.9) {
			return "Sua Classificação é Obesidade II";
		} else {
			return "Sua Classificação é Obesidade Grave III";
		}
	}

}
