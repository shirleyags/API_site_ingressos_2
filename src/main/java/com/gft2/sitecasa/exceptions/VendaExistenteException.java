package com.gft2.sitecasa.exceptions;

public class VendaExistenteException extends RuntimeException {
	
	//RuntimeException = Excessão não checada

	

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public VendaExistenteException(String mensagem) {

			super(mensagem); //super = Construtor da classe RuntimeException
		}

		public VendaExistenteException(String mensagem, Throwable causa) {

			super(mensagem, causa);
		}

}
