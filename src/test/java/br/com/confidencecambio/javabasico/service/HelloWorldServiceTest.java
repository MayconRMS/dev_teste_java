package br.com.confidencecambio.javabasico.service;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.confidencecambio.javabasico.dto.request.DadosRequest;

@SpringBootTest
class HelloWorldServiceTest {

	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Autowired
	private HelloWorldService service;

	@Test
	public void quandoPassarUmNomeQueroEleDeResposta() {
		var nome = "Meu Nome";
		String valorValido = service.retornaValorValido(nome);
		assertEquals(nome, valorValido);
	}

	@Test
	public void quandoPassarNuloQueroOPadrao() {
		String valorValido = service.retornaValorValido(null);
		assertEquals("Mundo", valorValido);
	}

	@Test
	public void quandoSucesso() {
		DadosRequest dadosRequest = new DadosRequest();
		dadosRequest.setAltura(1.70);
		dadosRequest.setPeso(80);
		Double valorValido = service.retornaImc(dadosRequest);
		assertEquals("27,68", new DecimalFormat("#,###.00").format(valorValido));
	}

	@Test
	public void quandoPassarNuloPeso() {
		DadosRequest dadosRequest = new DadosRequest();
		dadosRequest.setAltura(1.70);
		dadosRequest.setPeso(null);

		Set<ConstraintViolation<DadosRequest>> violations = validator.validate(dadosRequest);
		assertFalse(violations.isEmpty());

		ConstraintViolation<DadosRequest> constraintViolation = violations.stream().findAny().get();
		assertEquals("Peso deve ser informado.", constraintViolation.getMessage());
	}

	@Test
	public void quandoPassarNuloAltura() {
		DadosRequest dadosRequest = new DadosRequest();
		dadosRequest.setAltura(null);
		dadosRequest.setPeso(80);

		Set<ConstraintViolation<DadosRequest>> violations = validator.validate(dadosRequest);
		assertFalse(violations.isEmpty());

		ConstraintViolation<DadosRequest> constraintViolation = violations.stream().findAny().get();
		assertEquals("Altura deve ser informada.", constraintViolation.getMessage());
	}
	
	@Test
	public void quandoPassarPesoZero() {
		DadosRequest dadosRequest = new DadosRequest();
		dadosRequest.setAltura(1.70);
		dadosRequest.setPeso(0);

		Set<ConstraintViolation<DadosRequest>> violations = validator.validate(dadosRequest);
		assertFalse(violations.isEmpty());

		ConstraintViolation<DadosRequest> constraintViolation = violations.stream().findAny().get();
		System.out.println(constraintViolation.getMessage());
		assertEquals("Peso deve ter mais de 1 kg.", constraintViolation.getMessage());
	}
	
	@Test
	public void quandoPassarAlturaZero() {
		DadosRequest dadosRequest = new DadosRequest();
		dadosRequest.setAltura(0.00);
		dadosRequest.setPeso(80);

		Set<ConstraintViolation<DadosRequest>> violations = validator.validate(dadosRequest);
		assertFalse(violations.isEmpty());

		ConstraintViolation<DadosRequest> constraintViolation = violations.stream().findAny().get();
		System.out.println(constraintViolation.getMessage());
		assertEquals("Altura deve ter mais que 1 metro.", constraintViolation.getMessage());
	}

}
