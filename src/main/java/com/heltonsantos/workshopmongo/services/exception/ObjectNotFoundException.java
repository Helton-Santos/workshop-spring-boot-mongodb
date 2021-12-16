package com.heltonsantos.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg); // Repassar a mensagem para a SuperClasse RuntimeException / Forward the message for the RuntimeException SuperClass
		
	}

}
