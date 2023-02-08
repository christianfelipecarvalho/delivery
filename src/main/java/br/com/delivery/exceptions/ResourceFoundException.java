package br.com.delivery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceFoundException(String ex) {
		super(ex);
	}
	

}
