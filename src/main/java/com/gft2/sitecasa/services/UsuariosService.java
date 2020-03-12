package com.gft2.sitecasa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gft2.sitecasa.domain.Usuario;
import com.gft2.sitecasa.exceptions.UsuarioExistenteException;
import com.gft2.sitecasa.exceptions.UsuarioNaoEncontradoException;
import com.gft2.sitecasa.repository.UsuarioRepository;

@Service
public class UsuariosService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	
	
	public List<Usuario> listar(){
		List<Usuario> usuario = usuarioRepository.findAll();
		if (usuario==null) {
			throw new UsuarioNaoEncontradoException("O usuário não pôde ser encontrado!");
		}
		return usuario;
		
	}

	public Optional<Usuario> buscar(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			throw new UsuarioNaoEncontradoException("O usuário não pôde ser encontrado!");
		}
		return usuario;
	}
	
	public Usuario salvar(Usuario usuario) {
		if(usuario.getId() != null){
			
			Usuario a = usuarioRepository.findById(usuario.getId()).get();
			
			if(a !=null) {
				throw new UsuarioExistenteException("Usuário já existe.");
			}
			
		}
		return usuarioRepository.save(usuario) ;
	}

}
