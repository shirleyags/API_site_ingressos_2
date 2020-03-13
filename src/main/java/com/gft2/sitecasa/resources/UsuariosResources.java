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
import com.gft2.sitecasa.domain.Usuario;
import com.gft2.sitecasa.services.UsuariosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="Usuários")
@RestController
@RequestMapping("/api/users")
public class UsuariosResources {
	
	@Autowired
	private UsuariosService usuariosService;
	
	
	@ApiOperation("Lista usuários cadastrados")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(usuariosService.listar());
	}
	
	
	@ApiOperation("Busca usuários específicos por ID")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Usuario>> buscar(@ApiParam(value="ID do usuário", example="1")@PathVariable("id") Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(usuariosService.buscar(id));
	}
	
	
	@ApiOperation("Salva usuários")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@ApiParam (value="Representação de um novo usuário")@Valid @RequestBody Usuario usuario) {
		usuario = usuariosService.salvar(usuario);

		URI umaUri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

		return ResponseEntity.created(umaUri).build();
	}
	
	
	

}