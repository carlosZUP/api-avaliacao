package br.com.zup.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReceitaException extends RuntimeException {
	public ReceitaException(String receita) {
		super(receita);
	}
}