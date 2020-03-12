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


import com.gft2.sitecasa.domain.Venda;
import com.gft2.sitecasa.services.VendasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Api(tags="Vendas")
@RestController
@RequestMapping("/api/vendas")
public class VendasResource {
	
	
	@Autowired
	private VendasService vendasService;
	
	
	@ApiOperation("Lista vendas efetuadas")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Venda>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(vendasService.listar());
	}
	
	@ApiOperation("Busca vendas específicas por ID")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Venda>> buscar(@ApiParam(value="ID de uma venda", example="1")@PathVariable("id") Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(vendasService.buscar(id));
	}
	
	@ApiOperation("Salva vendas")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@ApiParam (value="Representação de uma nova venda")@Valid @RequestBody Venda venda) {
		venda = vendasService.salvar(venda);

		URI umaUri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

		return ResponseEntity.created(umaUri).build();
	}

}
