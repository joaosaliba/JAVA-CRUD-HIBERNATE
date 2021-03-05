package com.SalinBank.persistence;

import java.io.Serializable;

import com.SalinBank.entity.Conta;

public class ContaDAO extends GenericDAO<Conta, Serializable> {
	
	public ContaDAO(){
		super(Conta.class);
	}

}
