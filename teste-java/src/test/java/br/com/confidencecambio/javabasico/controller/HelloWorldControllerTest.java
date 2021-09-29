package br.com.confidencecambio.javabasico.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.confidencecambio.javabasico.dto.Cliente;
import br.com.confidencecambio.javabasico.dto.Gerente;
import br.com.confidencecambio.javabasico.dto.Robo;
import br.com.confidencecambio.javabasico.dto.response.NomePersonalizadoResponse;
import br.com.confidencecambio.javabasico.service.HelloWorldService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private HelloWorldService service;

	private NomePersonalizadoResponse getNomeSucesso() {
		NomePersonalizadoResponse nomeResponse = new NomePersonalizadoResponse();
		nomeResponse.setPrmeiroNome("João");
		nomeResponse.setUltimoNome("Soares Silva");
		nomeResponse.setMaiusculoNome("JOÃO SOARES SILVA");
		nomeResponse.setAbreviadoNome("João S. Silva");

		return nomeResponse;
	}

	@Test
	public void clienteSucess() throws Exception {
		Cliente cliente = new Cliente();
		cliente.setNome("João Soares Silva");

		MvcResult result = mockMvc.perform(
				get("/cliente").contentType("application/json").content(objectMapper.writeValueAsString(cliente)))
				.andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		assertEquals(content, objectMapper.writeValueAsString(getNomeSucesso()));

	}

	@Test
	public void clienteErroIniciaComEspaço() throws Exception {
		Cliente cliente = new Cliente();
		cliente.setNome(" João Soares Silva");

		mockMvc.perform(
				get("/cliente").contentType("application/json").content(objectMapper.writeValueAsString(cliente)))
				.andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	public void clienteErroFinalizaComEspaço() throws Exception {
		Cliente cliente = new Cliente();
		cliente.setNome(" João Soares Silva");

		mockMvc.perform(
				get("/cliente").contentType("application/json").content(objectMapper.writeValueAsString(cliente)))
				.andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	public void clienteErroNomeIncompleto() throws Exception {
		Cliente cliente = new Cliente();
		cliente.setNome("João");

		mockMvc.perform(
				get("/cliente").contentType("application/json").content(objectMapper.writeValueAsString(cliente)))
				.andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	public void gerenteSucess() throws Exception {
		Gerente gerente = new Gerente();
		gerente.setNome("João Soares Silva");

		MvcResult result = mockMvc.perform(
				get("/gerente").contentType("application/json").content(objectMapper.writeValueAsString(gerente)))
				.andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		assertEquals(content, objectMapper.writeValueAsString(getNomeSucesso()));

	}

	@Test
	public void gerenteErroIniciaComEspaço() throws Exception {
		Gerente gerente = new Gerente();
		gerente.setNome(" João Soares Silva");

		mockMvc.perform(
				get("/gerente").contentType("application/json").content(objectMapper.writeValueAsString(gerente)))
				.andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	public void gerenteErroFinalizaComEspaço() throws Exception {
		Gerente gerente = new Gerente();
		gerente.setNome(" João Soares Silva");

		mockMvc.perform(
				get("/gerente").contentType("application/json").content(objectMapper.writeValueAsString(gerente)))
				.andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	public void gerenteErroNomeIncompleto() throws Exception {
		Gerente gerente = new Gerente();
		gerente.setNome("João");

		mockMvc.perform(
				get("/gerente").contentType("application/json").content(objectMapper.writeValueAsString(gerente)))
				.andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	public void RoboSucess() throws Exception {
		Robo robo = new Robo();
		robo.setNome("João Soares Silva");

		MvcResult result = mockMvc
				.perform(get("/robo").contentType("application/json").content(objectMapper.writeValueAsString(robo)))
				.andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		assertEquals(content, objectMapper.writeValueAsString(getNomeSucesso()));

	}

	@Test
	public void RoboErroIniciaComEspaço() throws Exception {
		Robo robo = new Robo();
		robo.setNome(" João Soares Silva");

		mockMvc.perform(get("/robo").contentType("application/json").content(objectMapper.writeValueAsString(robo)))
				.andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	public void RoboErroFinalizaComEspaço() throws Exception {
		Robo robo = new Robo();
		robo.setNome(" João Soares Silva");

		mockMvc.perform(get("/robo").contentType("application/json").content(objectMapper.writeValueAsString(robo)))
				.andExpect(status().isBadRequest()).andReturn();
	}

	@Test
	public void roboErroNomeIncompleto() throws Exception {
		Robo robo = new Robo();
		robo.setNome("João");

		mockMvc.perform(get("/robo").contentType("application/json").content(objectMapper.writeValueAsString(robo)))
				.andExpect(status().isBadRequest()).andReturn();
	}

}
