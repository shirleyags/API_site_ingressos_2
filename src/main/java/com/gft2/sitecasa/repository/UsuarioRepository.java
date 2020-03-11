package com.gft2.sitecasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft2.sitecasa.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
