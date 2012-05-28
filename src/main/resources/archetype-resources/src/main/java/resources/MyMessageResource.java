package ${package}.resources;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.inject.Inject;
import ${package}.services.MessageService;

@Path("/message")
public class MyMessageResource {

	@Inject
	MessageService messageService;
	
	@GET
	@Path("/hello")
	public String sayHello(){
		return messageService.getMessage();
	}
	
	@POST
	@Path("/save")
	public Integer saveMessage(@QueryParam("message") String message) {
		return null;
	}

	@PUT
	@Path("/update/{messageId}")
	public void updateMessage(@PathParam("messageId") Integer id,
			@QueryParam("newMessage") String newMessage) {

	}

	@GET
	@Path("/{messageId}")
	public String getMessage(@PathParam("messageId") Integer id) {
		return null;
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") Integer id){
		
	}
}
