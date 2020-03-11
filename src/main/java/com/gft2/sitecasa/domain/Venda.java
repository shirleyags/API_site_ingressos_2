package com.gft2.sitecasa.domain;

import java.math.BigDecimal;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Venda {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotEmpty(message="O nome do evento é obrigatório.")
	@Size(max=60, message="A casa não pdoe ter mais que 60 caracteres.")
	private String evento;
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@NotNull(message="O preenchimento da quantidade é obrigatório.")
	private Integer quantidadeDeIngressos;
	
	@NotNull(message="O preenchimento do valor é obrigatório.")
	@NumberFormat(pattern = "#,##0.00")
	@DecimalMin(value="0.01", message="O valor não pode ser menor que 0,01")
	@DecimalMax(value="9999999.99", message="O valor não pode ser maior que R$ 9.999.999,99")
	private BigDecimal valorTotal;
	
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_fk")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Usuario usuario;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEvento() {
		return evento;
	}


	public void setEvento(String evento) {
		this.evento = evento;
	}


	public Integer getQuantidadeDeIngressos() {
		return quantidadeDeIngressos;
	}


	public void setQuantidadeDeIngressos(Integer quantidadeDeIngressos) {
		this.quantidadeDeIngressos = quantidadeDeIngressos;
	}


	public BigDecimal getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	

	
	

}
