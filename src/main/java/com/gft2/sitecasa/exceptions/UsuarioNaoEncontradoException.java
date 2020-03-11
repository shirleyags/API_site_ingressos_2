package com.gft2.sitecasa.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException  {
	
	//RuntimeException = Excessão não checada

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradoException(String mensagem) {

		super(mensagem); //super = Construtor da classe RuntimeException
	}

	public UsuarioNaoEncontradoException(String mensagem, Throwable causa) {

		super(mensagem, causa);
	}

}
