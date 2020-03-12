package com.gft2.sitecasa.resources;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.gft2.sitecasa.services.CasasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@Api(tags="Casas de show")
@RestController
@RequestMapping("/api/casas")
public class CasasResource {	

	@Autowired
	private CasasService casasService;

	
	@ApiOperation("Lista as casas de show cadastradas")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CasaShow>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(casasService.listar());

	}

	@ApiOperation("Salva  as casas de show")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@ApiParam (value="Representação de uma nova casa de show") @Valid @RequestBody CasaShow casa) {
		casa = casasService.salvar(casa);

		URI umaUri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

		return ResponseEntity.created(umaUri).build();
	}

	
	@ApiOperation("Busca as casas de show")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<CasaShow>> buscar(@ApiParam(value="ID da casa de show", example="1") @PathVariable("id") Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(casasService.buscar(id));
	}
	
	
	@ApiOperation("Apaga as casas de show por ID")
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deletar(@ApiParam(value="ID da casa de show", example="1") @PathVariable("id")Long id) {
		casasService.deletar(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	@ApiOperation("Atualiza as casas de show")
	@RequestMapping(value ="/{id}", method = RequestMethod.PUT) 
	public  ResponseEntity<Void> atualizar(@ApiParam(name="corpo", value="Representação da casa de show com novos dados")@RequestBody CasaShow cadaShow, @ApiParam(value="ID de uma casa de show", example="1")@PathVariable("id")Long id) {
		cadaShow.setId(id);
		casasService.atualizar(cadaShow);
	return ResponseEntity.noContent().build();
	}
	

	@ApiOperation("Lista as casas de show em ordem alfabética crescente")
	@RequestMapping (value ="/asc", method = RequestMethod.GET)
	public ResponseEntity<List<CasaShow>> listarOrdemAlfabeticaCrescente() {
		return ResponseEntity.status(HttpStatus.OK).body(casasService.listarOrdemAlfabeticaCrescente());
	}
	
	@ApiOperation("Lista as casas de show em ordem alfabética decrescente")
	@RequestMapping (value ="/desc", method = RequestMethod.GET)
	public ResponseEntity<List<CasaShow>> listarOrdemAlfabeticaDecrescente() {
		return ResponseEntity.status(HttpStatus.OK).body(casasService.listarOrdemAlfabeticaDecrescente());
	}
	
	
	@ApiOperation("Permite a localização da casa de show pelo nome")
	@RequestMapping (value ="/nome/{casa}", method = RequestMethod.GET)
	public ResponseEntity<List<CasaShow>> pesquisar(@ApiParam(value="Nome da casa de show", example="1")@PathVariable("casa")String casa){
		return ResponseEntity.status(HttpStatus.OK).body(casasService.pesquisar(casa));
	}
	

}
