package com.SalinBank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "BANCO")
public class Banco {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_BANCO")
	private Integer id;
	
	@Column(name="BANCO_CNPJ")
	private Long cnpj;
	
	@Column(name="NUM_BANCO")
	private  Long num_banco;
	
	@Column(name="RAZAO_SOCIAL")
	private String razao_social;
	
	public Banco() {
		
	}
	
	public Banco(Integer id, Long cnpj, Long num_banco,String razao_social) {
		this.id = id;
		this.cnpj = cnpj;
		this.num_banco = num_banco;
		this.razao_social = razao_social;
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	
	public Long getNum_banco() {
		return num_banco;
	}
	public void setNum_banco(Long num_banco) {
		this.num_banco = num_banco;
	}
	public String getRazao_social() {
		return razao_social;
	}
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	
	
	
	
	
}
