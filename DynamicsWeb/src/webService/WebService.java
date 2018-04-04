package webService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import bean.Eleve;

@Path("/WebService")
public class WebService {

	@Path("/getEleve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/DynamicsWeb/ws/WebService/getEleve
	public Response getEleve() {
		Eleve eleve = new Eleve("bob");
		Gson gson = new Gson();
		return Response.status(200).entity(gson.toJson(eleve)).build();
	}

	@Path("/giveEleveWithParams")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/DynamicsWeb/ws/WebService/giveEleveWithParams
	public Response askWrite(@QueryParam("name") String name) {
		Eleve eleve = new Eleve(name);
		Gson gson = new Gson();
		return Response.status(200).entity(gson.toJson(eleve)).build();
	}

	@POST
	@Path("/giveElevePost")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEleveWithParam(String recu) {
		System.out.println(recu);
		Gson gson = new Gson();
		Eleve eleve = gson.fromJson(recu, Eleve.class);
		return Response.status(200).entity(gson.toJson(eleve)).build();
	}

}
