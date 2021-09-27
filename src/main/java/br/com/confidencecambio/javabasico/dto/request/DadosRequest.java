package br.com.confidencecambio.javabasico.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosRequest {
	
	@NotNull(message = "Peso deve ser informado.")
	@Min(value = 1, message = "Peso deve ter mais de 1 kg.")
	private Integer peso;
	
	@NotNull(message = "Altura deve ser informada.")
	@Min(value = 1 , message = "Altura deve ter mais que 1 metro.")
	private Double altura;

}
