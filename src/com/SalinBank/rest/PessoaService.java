package com.SalinBank.rest;

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

import com.SalinBank.entity.Pessoa;
import com.SalinBank.persistence.PessoaDAO;

@Path("/pessoa")
public class PessoaService {


	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	private PessoaDAO dao;
	
	public PessoaService(){
		dao = new PessoaDAO();
	}

	protected void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response PessoaCreate(Pessoa Pessoa) {
		try {
			dao.save(Pessoa);
			return Response.status(200).entity("Cadastrado").build();
			 
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao adicionar novo ").build();
		}
	}

	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response PessoaRead() {
		List<Pessoa> Pessoa = new ArrayList<>();
		try {
			Pessoa = dao.getAll();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar Pessoa").build();
		}

		GenericEntity<List<Pessoa>> entity = new GenericEntity<List<Pessoa>>(Pessoa) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}


	
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response PessoaDelete(@PathParam("id") Integer id) {
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
	public Response PessoaUpdate(@PathParam("id") Integer id, Pessoa Pessoa) {
		try {
			Pessoa entity = new Pessoa();
			Pessoa.setId(id);
			entity= dao.update(Pessoa);
			return Response.status(200).entity(entity ).build();
		}catch (Exception e ) {
			throw new WebApplicationException(500);
		}finally {
			
		}
	}
}
