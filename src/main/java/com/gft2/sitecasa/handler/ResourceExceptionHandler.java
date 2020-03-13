package com.gft2.sitecasa.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import com.fasterxml.jackson.core.JsonParseException;
import com.gft2.sitecasa.exceptions.CasaDeShowExistenteException;
import com.gft2.sitecasa.exceptions.CasaDeShowNaoExistenteException;
import com.gft2.sitecasa.exceptions.EventoExistenteException;
import com.gft2.sitecasa.exceptions.EventoNaoEncontradoException;
import com.gft2.sitecasa.exceptions.UsuarioExistenteException;
import com.gft2.sitecasa.exceptions.UsuarioNaoEncontradoException;
import com.gft2.sitecasa.exceptions.VendaExistenteException;
import com.gft2.sitecasa.exceptions.VendaNaoEncontradaException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	
	
	//Erros eventos--------------------------------------------------------------------------------

	@ExceptionHandler(EventoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleEventoNaoEncontradoException (EventoNaoEncontradoException e, HttpServletRequest resquest) {
		
		
		//Instaciar um objeto dessa (DetalheErro) classe e setar.
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O evento não pôde ser encontrado!");
		erro.setTimestamp(System.currentTimeMillis()); //Para trazer a mensagem de erro em milesegundos
		erro.setMensagemDesenvolvedor("http://erros.siteingressos.com/404");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
				}
	
	@ExceptionHandler(EventoExistenteException.class) //
	public ResponseEntity<DetalhesErro> handleEventoExistenteException (EventoExistenteException  e, HttpServletRequest request) {
		
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Evento já existente!");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor("http://erros.siteingressos.com/409");

		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	
	//Erros casa de show--------------------------------------------------------------------------------
	
	@ExceptionHandler(CasaDeShowExistenteException .class) //
	public ResponseEntity<DetalhesErro> handleCasadeShowExistenteException (CasaDeShowExistenteException  e, HttpServletRequest request) {
		
		
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Casa de Show já existente!");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor("http://erros.siteingressos.com/409");

		
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
				}
	
	
	@ExceptionHandler(CasaDeShowNaoExistenteException.class) //
	public ResponseEntity<DetalhesErro> handleCasaDeShowNaoExistenteException (CasaDeShowNaoExistenteException e, HttpServletRequest request) {
		
		
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Casa de Show não encontrada!");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor("http://erros.siteingressos.com/404");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
				}
	
	
	//Erros usuário--------------------------------------------------------------------------------
	
	@ExceptionHandler(UsuarioExistenteException.class) //
	public ResponseEntity<DetalhesErro> handleUsuarioExistenteException (UsuarioExistenteException  e, HttpServletRequest request) {
		
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Usuário já existente!");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor("http://erros.siteingressos.com/409");

		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	

	
	
	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleUsuarioNaoEncontradoException (UsuarioNaoEncontradoException e, HttpServletRequest request) {
		
		
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Usuário(s) não encontrado(s)!");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor("http://erros.siteingressos.com/404");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
				}
	
	
	
	
	//Erros vendas --------------------------------------------------------------------------------
	
	@ExceptionHandler(VendaNaoEncontradaException.class) //
	public ResponseEntity<DetalhesErro> handleVendaNaoEncontradaException (VendaNaoEncontradaException e, HttpServletRequest request) {
		
		
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Venda não encontrada!");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor("http://erros.siteingressos.com/404");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
				}
	
	@ExceptionHandler(VendaExistenteException.class) //
	public ResponseEntity<DetalhesErro> handleVendaExistenteException (VendaExistenteException e, HttpServletRequest request) {
		
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Venda já existente!");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor("http//:erros.siteingressos.com/409");

		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	

	//Erros gerais--------------------------------------------------------------------------------

	@ExceptionHandler(DataIntegrityViolationException.class) //
	public ResponseEntity<DetalhesErro> handlesDataIntegrityViolationException (DataIntegrityViolationException e, HttpServletRequest request) {
		
		
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição inválida!");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor("http://erros.siteingressos.com/400");

		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		
				}
				

}
