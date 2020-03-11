package com.gft2.sitecasa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;



@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@NotEmpty(message = "O nome completo é obrigatório")
	@Size(max = 60, message = "O nome completo não pode conter mais de 60 caracteres.")
	private String nomeCompleto;
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@NotEmpty(message = "O e-mail é obrigatório.")
	@Size(max = 60, message = "O e-mail não pode conter mais de 60 caracteres.")
	private String email;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@NotEmpty(message = "A escolha de um username é obrigatório")
	@Size(max = 10, message = "O username não pode conter mais de 10 caracteres.")
	private String user;
	
	
	@JsonIgnore
	private String senha;
	

	@JsonInclude(JsonInclude.Include.NON_EMPTY) 
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "usuario")
	@JsonIgnore
	private  List<Venda> listaVenda;


	

	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public List<Venda> getListaVenda() {
		return listaVenda;
	}


	public void setListaVenda(List<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}


	
	
}
