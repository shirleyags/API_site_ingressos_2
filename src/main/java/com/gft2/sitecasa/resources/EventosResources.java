package com.gft2.sitecasa.resources;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gft2.sitecasa.domain.CasaShow;
import com.gft2.sitecasa.domain.Eventos;
import com.gft2.sitecasa.services.EventosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Api(tags="Eventos")
@RestController
@RequestMapping("/api/eventos")
public class EventosResources {
	
	@Autowired
	EventosService eventosService;
	
	
	@ApiOperation("Lista eventos cadastrados")
	@RequestMapping(method = RequestMethod.GET) // VAI PEGAR DO BANCO E FAZER APARECER
	public ResponseEntity<List<Eventos>> listar() {
		
		return ResponseEntity.status(HttpStatus.OK).body(eventosService.listar()); //Usa-se findAll(), pois se refere a uma lista
		
	}
	
	
	@ApiOperation("Salva eventos")
	@RequestMapping(method = RequestMethod.POST) //É POST PORQUE VAI PEGAR DA URL E SALVAR
	public ResponseEntity<Void> salvar(@ApiParam (value="Representação de uma novo evento")@Valid @RequestBody Eventos cadaEvento){ 
		eventosService.salvar(cadaEvento);
		
		URI umaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cadaEvento.getId()).toUri();
		
		return ResponseEntity.created(umaUri).build();
	}
	
	@ApiOperation("Busca eventos específicos por ID")
	@RequestMapping(value ="/{id}", method = RequestMethod.GET) //Trazer é GET
		public ResponseEntity<?> buscar(@ApiParam(value="ID de um evento", example="1")@PathVariable("id")Long id){
		Optional<Eventos> cadaEvento = eventosService.buscar(id);
	
			return ResponseEntity.status(HttpStatus.OK).body(cadaEvento);
		}
	
	
	
	@ApiOperation("Deleta eventos")
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deletar(@ApiParam(value="ID de um evento", example="1")@PathVariable("id")Long id) {
		eventosService.deletar(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@ApiOperation("Edita informações do evento")
	@RequestMapping(value ="/{id}", method = RequestMethod.PUT) 
	public  ResponseEntity<Void> atualizar(@ApiParam(name="corpo", value="Representação do evento com novos dados") @RequestBody Eventos cadaEvento, @ApiParam(value="ID de um evento", example="1")@PathVariable("id")Long id) {
		cadaEvento.setId(id);
		eventosService.atualizar(cadaEvento);
	return ResponseEntity.noContent().build();
	}
	
	
	@ApiOperation("Lista a lotação do evento em ordem crescente")
	@RequestMapping (value ="/capacidade/asc", method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarCapacidadeAsc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosService.listarCapacidadeAsc());
	}
	
	
	@ApiOperation("Lista a lotação do evento em ordem decrescente")
	@RequestMapping (value ="/capacidade/desc", method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarCapacidadeDesc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosService.listarCapacidadeDesc());
	}
	
	@ApiOperation("Lista a data do evento em ordem crescente")
	@RequestMapping (value ="/data/asc", method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarDataAsc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosService.listarDataAsc());
	}
	
	
	@ApiOperation("Lista a data do evento em ordem decrescente")
	@RequestMapping (value ="/data/desc", method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarDataDesc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosService.listarDataDesc());
	}
	
	
	@ApiOperation("Lista o nome do evento em ordem crescente")
	@RequestMapping (value ="/nome/asc", method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarNomeAsc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosService.listarNomeAsc());
	}
	
	
	@ApiOperation("Lista o nome do evento em ordem decrescente")
	@RequestMapping (value ="/nome/desc", method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarNomeDesc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosService.listarNomeDesc());
	}
	
	
	@ApiOperation("Lista o preço do evento em ordem crescente")
	@RequestMapping (value ="/preco/asc", method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarPrecoAsc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosService.listarPrecoAsc());
	}
	
	@ApiOperation("Lista o preço do evento em ordem decrescente")
	@RequestMapping (value ="/preco/desc", method = RequestMethod.GET)
	public ResponseEntity<List<Eventos>> listarPrecoDesc() {
		return ResponseEntity.status(HttpStatus.OK).body(eventosService.listarPrecoDesc());
	}
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping(value="/{id}/comentarios", method = RequestMethod.POST)
//	public ResponseEntity<Void> adicionarComentario(@PathVariable("id")Long livroId, @RequestBody Comentario cadaComentario) {
//		eventosService.salvarComentario(livroId, cadaComentario);
//		
//		//URI umaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand().toUri();//Estrutura para buscar 
//		//cada comentário
//		
//		URI umaUri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri(); //Para buscar todos os comentários
//		
//		return ResponseEntity.created(umaUri).build();
//				
//	}
//	
//	@RequestMapping(value="/{id}/comentarios", method = RequestMethod.GET)
//	public ResponseEntity<List<Comentario>> listarComentario(@PathVariable("id")Long livroId){
//		List<Comentario> comentarios = livrosService.listarComentario(livroId);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(comentarios);
//		
//		
//	}
//		
	
	
	
	
	
	
}




