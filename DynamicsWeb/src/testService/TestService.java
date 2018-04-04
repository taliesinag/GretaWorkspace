
package testService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/MonService")
public class TestService {

	@Path("/helloWorld")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	// http://localhost:8080/DynamicsWeb/rest/MonService/helloWorld
	public String hello() {
		System.out.println("HellowWorld !!");
		return "HelloWorld";
	}

}
