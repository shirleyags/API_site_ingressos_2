package com.gft2.sitecasa.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gft2.sitecasa.domain.Venda;
import com.gft2.sitecasa.exceptions.VendaExistenteException;
import com.gft2.sitecasa.exceptions.VendaNaoEncontradaException;
import com.gft2.sitecasa.repository.VendasRepository;

@Service
public class VendasService {
	
	@Autowired
	private VendasRepository vendasRepository;
	
	public List<Venda> listar(){
		List<Venda> venda = vendasRepository.findAll();
		if (venda.isEmpty()) {
			throw new VendaNaoEncontradaException("A venda não pôde ser encontrado!");
		}
		return venda;
		
	}

	public Optional<Venda> buscar(Long id) {
		Optional<Venda> venda = vendasRepository.findById(id);
		if (venda.isEmpty()) {
			throw new VendaNaoEncontradaException("A venda pôde ser encontrado!");
		}
		return venda;
	}
	
	public Venda salvar(Venda venda) {
		if(venda.getId() != null){
			
			Venda a = vendasRepository.findById(venda.getId()).get();
			
			if(a !=null) {
				throw new VendaExistenteException("A venda já existe.");
			}
			
		}
		return vendasRepository.save(venda) ;
	}

}


