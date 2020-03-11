package com.gft2.sitecasa.exceptions;

public class VendaNaoEncontradaException extends RuntimeException  {
	
	//RuntimeException = Excessão não checada

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VendaNaoEncontradaException(String mensagem) {

		super(mensagem); 
	}

	public VendaNaoEncontradaException(String mensagem, Throwable causa) {

		super(mensagem, causa);
	}

}
