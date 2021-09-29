package br.com.confidencecambio.javabasico.dto;

import br.com.confidencecambio.javabasico.exception.DadosStatusException;

public class NomePersonalizado {

	public void validName(String nome) {
		if (nome.startsWith(" ")) {
			throw new DadosStatusException("Nome não pode iniciar com espaço!");
		}
		if (nome.endsWith(" ")) {
			throw new DadosStatusException("Nome não pode finalizar com espaço!");
		}

		if (nome.split(" ").length <= 1) {
			throw new DadosStatusException("Digite o nome completo!");
		}
	}

	public String primeiroNome(String nome) {
		validName(nome);
		return nome.substring(0, nome.indexOf(" "));
	}

	public String ultimoNome(String nome) {
		validName(nome);
		return nome.substring(nome.indexOf(" ") + 1, nome.length());
	}

	public String nomeMaiusculo(String nome) {
		validName(nome);
		return nome.toUpperCase();
	}

	public String nomeAbreviado(String nome) {
		validName(nome);
		String nomePedacos[] = nome.split(" ");
		String abreviado = nomePedacos[0] + " ";

		for (int x = 1; x < nomePedacos.length - 1; x++) {
			String nomeList = nomePedacos[x];
			if (!nomeList.equalsIgnoreCase("da") && !nomeList.equalsIgnoreCase("de")
					&& !nomeList.equalsIgnoreCase("do")) {
				abreviado += (nomePedacos[x].substring(0, 1) + ".") + " ";
			}

		}

		abreviado += nomePedacos[nomePedacos.length - 1];
		return abreviado;
	}

}
