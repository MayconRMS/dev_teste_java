package br.com.confidencecambio.javabasico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.dto.Cliente;
import br.com.confidencecambio.javabasico.dto.Gerente;
import br.com.confidencecambio.javabasico.dto.Robo;
import br.com.confidencecambio.javabasico.dto.request.DadosRequest;
import br.com.confidencecambio.javabasico.dto.response.DadosResponse;
import br.com.confidencecambio.javabasico.dto.response.NomePersonalizadoResponse;
import br.com.confidencecambio.javabasico.service.HelloWorldService;

@RestController
public class HelloWorldController {

	@Autowired
	private HelloWorldService service;

	@GetMapping("/ola-mundo")
	public ResponseEntity<String> olaMundo(@RequestParam(value = "nome", required = false) String nome) {
		var retorno = "Ola " + service.retornaValorValido(nome);
		return new ResponseEntity<>(retorno, HttpStatus.OK);
	}

	@GetMapping("/imc")
	public ResponseEntity<DadosResponse> getImc(@Valid @RequestBody DadosRequest imcDto) {
		Double imc = service.retornaImc(imcDto);
		DadosResponse dados = new DadosResponse(imc, service.retornaDescricaoImc(imc));
		return new ResponseEntity<>(dados, HttpStatus.OK);
	}

	@GetMapping("/cliente")
	public ResponseEntity<NomePersonalizadoResponse> cliente(@Valid @RequestBody Cliente cliente) {
		NomePersonalizadoResponse nomePersonalizado = new NomePersonalizadoResponse();
		nomePersonalizado.setPrmeiroNome(cliente.primeiroNome(cliente.getNome()));
		nomePersonalizado.setUltimoNome(cliente.ultimoNome(cliente.getNome()));
		nomePersonalizado.setMaiusculoNome(cliente.nomeMaiusculo(cliente.getNome()));
		nomePersonalizado.setAbreviadoNome(cliente.nomeAbreviado(cliente.getNome()));
		
		return new ResponseEntity<>(nomePersonalizado, HttpStatus.OK);
	}
	
	@GetMapping("/gerente")
	public ResponseEntity<NomePersonalizadoResponse> gerente(@Valid @RequestBody Gerente gerente) {
		NomePersonalizadoResponse nomePersonalizado = new NomePersonalizadoResponse();
		nomePersonalizado.setPrmeiroNome(gerente.primeiroNome(gerente.getNome()));
		nomePersonalizado.setUltimoNome(gerente.ultimoNome(gerente.getNome()));
		nomePersonalizado.setMaiusculoNome(gerente.nomeMaiusculo(gerente.getNome()));
		nomePersonalizado.setAbreviadoNome(gerente.nomeAbreviado(gerente.getNome()));
		
		return new ResponseEntity<>(nomePersonalizado, HttpStatus.OK);
	}
	
	@GetMapping("/robo")
	public ResponseEntity<NomePersonalizadoResponse> robo(@Valid @RequestBody Robo robo) {
		NomePersonalizadoResponse nomePersonalizado = new NomePersonalizadoResponse();
		nomePersonalizado.setPrmeiroNome(robo.primeiroNome(robo.getNome()));
		nomePersonalizado.setUltimoNome(robo.ultimoNome(robo.getNome()));
		nomePersonalizado.setMaiusculoNome(robo.nomeMaiusculo(robo.getNome()));
		nomePersonalizado.setAbreviadoNome(robo.nomeAbreviado(robo.getNome()));
		
		return new ResponseEntity<>(nomePersonalizado, HttpStatus.OK);
	}

}
