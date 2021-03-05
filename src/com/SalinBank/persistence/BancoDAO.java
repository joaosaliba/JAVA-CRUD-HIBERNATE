package com.SalinBank.persistence;

import java.io.Serializable;

import com.SalinBank.entity.Banco;

public class BancoDAO extends GenericDAO<Banco, Serializable> {
	 public BancoDAO() {
		 super(Banco.class);
	 }


}
