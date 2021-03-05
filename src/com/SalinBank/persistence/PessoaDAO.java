package com.SalinBank.persistence;

import java.io.Serializable;

import com.SalinBank.entity.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa, Serializable> {
	
	public PessoaDAO() {
		super(Pessoa.class);
	}

}
