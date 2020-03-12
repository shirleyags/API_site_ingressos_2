package com.gft2.sitecasa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft2.sitecasa.domain.CasaShow;

public interface CasasRepository extends JpaRepository <CasaShow, Long> {
	
	public CasaShow findByCasaContaining (String casa);

}
