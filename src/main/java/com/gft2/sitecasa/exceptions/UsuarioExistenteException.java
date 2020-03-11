package com.gft2.sitecasa.exceptions;

public class UsuarioExistenteException extends RuntimeException {
	
	//RuntimeException = Excessão não checada

	

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public UsuarioExistenteException(String mensagem) {

			super(mensagem); //super = Construtor da classe RuntimeException
		}

		public UsuarioExistenteException(String mensagem, Throwable causa) {

			super(mensagem, causa);
		}

}
