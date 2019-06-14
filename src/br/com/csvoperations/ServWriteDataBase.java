package br.com.csvoperations;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.csvreader.data.SchoolDB;
import br.com.csvreader.model.School;

//@Path("/database")
public class ServWriteDataBase {
	
	//@POST
	//@Path("/")
	//@Consumes("application/json")
	//@Produces("application/json")
	//public Response saveData(School school) {
		//try {
			//SchoolDB sdb = new SchoolDB();
			//System.out.println("TESTE");
			//if (sdb.insert(school)) {
				//return Response.status(201).build();
			//} else {
				//return Response.status(500).build();
			//}
		//} catch(SQLException e) {
			//return Response.status(500).build();
		//}
	//}
}