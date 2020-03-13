package com.gft2.sitecasa.exceptions;

public class EventoExistenteException extends RuntimeException {
	
	//RuntimeException = Excessão não checada

	

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public EventoExistenteException(String mensagem) {

			super(mensagem); //super = Construtor da classe RuntimeException
		}

		public EventoExistenteException(String mensagem, Throwable causa) {

			super(mensagem, causa);
		}

}
