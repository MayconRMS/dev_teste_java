package br.com.confidencecambio.javabasico.dto.response;

import java.text.DecimalFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosResponse {

	private String imc;
	private String descricao;
	
	public DadosResponse(Double imc, String descricao) {
		this.imc = new DecimalFormat("#,###.00").format(imc);
		this.descricao = descricao;
	}
	
}
