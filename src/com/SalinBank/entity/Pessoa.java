package com.SalinBank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "Person")
public class Pessoa {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID_PERSON")
	private Integer id;
	
	@Column(name="CPF")
	private Long cpf;
	
	@Column(name="NOME")
	private String nome;
	
	@OneToOne
	@JoinColumn(name="FK_conta")
	private Conta conta;
	
	
	public Pessoa() {
		
	}
	public Pessoa(Integer id, Long cpf, String nome, Conta conta) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.conta = conta;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
	
}
