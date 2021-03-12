package com.SalinBank.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.SalinBank.entity.Conta;
import com.SalinBank.persistence.ContaDAO;
import com.SalinBank.persistence.ContaDAO;
import com.SalinBank.persistence.GenericDAO;

@Path("/conta")
public class ContaService {


	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	private ContaDAO dao;
	
	public ContaService(){
		dao = new ContaDAO();
	}

	protected void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response ContaCreate(Conta Conta) {
		try {
			dao.save(Conta);
			return Response.status(200).entity("Cadastrado").build();
			 
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao adicionar novo ").build();
		}
	}

	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response ContaRead() {
		List<Conta> Conta = new ArrayList<>();
		try {
			Conta = dao.getAll();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar Conta").build();
		}

		GenericEntity<List<Conta>> entity = new GenericEntity<List<Conta>>(Conta) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}


	
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response ContaDelete(@PathParam("id") Integer id) {
		try {
			dao.delete(id);
			return Response.status(200).entity(" excluido com Sucesso").build();

		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	@Path("update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	public Response ContaUpdate(@PathParam("id") Integer id, Conta Conta) {
		try {
			Conta entity = new Conta();
			Conta.setId(id);
			entity= dao.update(Conta);
			return Response.status(200).entity(entity ).build();
		}catch (Exception e ) {
			throw new WebApplicationException(500);
		}finally {
			
		}
	}

    
   
}
