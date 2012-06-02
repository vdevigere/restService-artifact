package ${package}.resources;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;

import ${package}.persister.MessagePersister;

@Path("/message")
public class MyMessageResource {

	@Inject
	MessagePersister messagePersister;
		
	@POST
	@Path("/save")
	@Produces(MediaType.TEXT_PLAIN)
	public String saveMessage(@QueryParam("message") String message) {
		return messagePersister.save(message).toString();
	}

	@PUT
	@Path("/update/{messageId}")
	public void updateMessage(@PathParam("messageId") Integer id,
			@QueryParam("newMessage") String newMessage) {
		messagePersister.update(id, newMessage);
	}

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMessage(@PathParam("messageId") Integer id) {
		return messagePersister.getById(id).getMessage();
	}
	
	@DELETE
	@Path("/delete/{messageId}")
	public void deleteMessage(@PathParam("messageId") Integer id){
		messagePersister.deleteById(id);
	}
}
