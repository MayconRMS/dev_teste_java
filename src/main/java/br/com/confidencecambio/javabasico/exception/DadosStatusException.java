package br.com.confidencecambio.javabasico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DadosStatusException extends RuntimeException {

	private static final long serialVersionUID = -5275531788139814586L;
	
	public DadosStatusException() {
		super();
	}

	public DadosStatusException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DadosStatusException(String message, Throwable cause) {
		super(message, cause);
	}

	public DadosStatusException(String message) {
		super(message);
	}

	public DadosStatusException(Throwable cause) {
		super(cause);
	}

}
