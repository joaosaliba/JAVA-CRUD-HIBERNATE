package com.SalinBank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONTA")
public class Conta {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID_CONTA")
	private Integer id;
	
	@Column(name="CONTA")
	private Long num_conta;
	
	@ManyToOne
	@JoinColumn(name="FK_BANCO")
	private Banco banco;
	
	public Conta () {
		
	}
	
	public Conta(Integer id, Long num_conta, Banco banco) {
		this.id = id;
		this.num_conta = num_conta;
		this.banco = banco;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getNum_conta() {
		return num_conta;
	}
	public void setNum_conta(Long num_conta) {
		this.num_conta = num_conta;
	}
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	
	

}
