package br.com.csvoperations;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.csvreader.data.SchoolDB;
import br.com.csvreader.model.School;

@Path("/database")
public class ServFindAllDataBase {
	
	@GET
	@Path("/")
	@Produces("application/json")
	public Response getAll() {
		//System.out.println("Entrou aqui!");
		try {
			SchoolDB sdb = new SchoolDB();
			
			List<School> schools = sdb.getAll();
			String json = "[";
			
			for (School school : schools) {
				json += (json.length() == 1 ? "" : ",") + school.toJson();
			}
			
			json += "]";
			
			return Response.status(200).entity(json).build();
		} catch(SQLException e) {
			return Response.status(200).entity("Falha ao consultar o banco de dados").build();
		}
	}
	
	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public Response saveData(School school) {
		System.out.println("Entrou aqui!");
		try {
			SchoolDB sdb = new SchoolDB();
			
			if (sdb.insert(school)) {
				return Response.status(201).build();
			} else {
				return Response.status(500).build();
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(500).build();
		}
	}

}