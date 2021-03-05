package com.SalinBank.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;

public class GenericDAO<T, I extends Serializable> {
	
	
	
	private Class<T> persistedClass;
	
	public GenericDAO() {
		
	}
	protected GenericDAO(Class<T> persistedClass) {
		this();
		this.persistedClass =persistedClass;
	}
	
	public T save( @Valid T entity) throws Exception  {
		EntityManager t = HibernateUtil.getEntityManager();
		
		try{
			t.getTransaction().begin();
			t.persist(entity);
			t.flush();
			t.getTransaction().commit();
		}catch(Exception e) {
			t.getTransaction().rollback();
			throw new Exception(e);
		}finally {
			t.close();
		}
		
		
		
		return entity;
		
		
	}
	
	public T update(@Valid T newEntity) throws Exception {
		EntityManager t = HibernateUtil.getEntityManager();
		T entity = null;
		try {
			t.getTransaction().begin();
			entity = t.merge(newEntity);
			t.flush();
			t.getTransaction().commit();
		}catch( Exception e) {
			t.getTransaction().commit();
			throw new Exception(e);
			
		}finally {
			t.close();
		}
	
		return entity;
	}
	
	public T find(I id) throws Exception {
		EntityManager t = HibernateUtil.getEntityManager();
		T entity = null;
		try {
			entity = t.find(persistedClass, id);
		} catch(Exception e){
			t.getTransaction().rollback();
			throw new Exception(e);
		}finally {
			t.close();
		}
		
		
		return entity;
	}
	
	public void delete( I id) throws Exception {
		EntityManager t = HibernateUtil.getEntityManager();
		try {
			t.getTransaction().begin();
			T entity = t.find(persistedClass, id);
			t.remove(entity);
			t.flush();
			t.getTransaction().commit();
			
		}catch (Exception e){
			t.getTransaction().rollback();
			throw new Exception(e);
			
		}finally {
			t.close();
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> getAll() throws Exception {
		EntityManager t = HibernateUtil.getEntityManager();
		List<T> entity = new ArrayList<>();
		try {
			Query query = t.createQuery("FROM "+ persistedClass.getName());
			entity= query.getResultList();
		}catch (Exception e) {
			t.getTransaction().rollback();
			throw new Exception(e);
		}finally {
			t.close();
		}
		return entity;
	}

		
}
