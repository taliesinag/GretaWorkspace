package webService;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import bean.MessageBDD;
import bean.MessageBean;

@Path("/ChatService")
public class ChatService {

	@Path("/getMessages")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/DynamicsWeb/ws/ChatService/getMessages
	public Response getMessages() {
		Gson gson = new Gson();
		ArrayList<MessageBean> maList = MessageBDD.getMessages();
		System.out.println(gson.toJson(maList));
		return Response.status(200).entity(gson.toJson(maList)).build();
	}

	@POST
	@Path("/sendMessage")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/DynamicsWeb/ws/ChatService/sendMessage
	public void sendMessage(String messageRecu) {
		System.out.println(messageRecu);
		Gson gson = new Gson();
		MessageBDD.addMessage(gson.fromJson(messageRecu, MessageBean.class));

	}

}
