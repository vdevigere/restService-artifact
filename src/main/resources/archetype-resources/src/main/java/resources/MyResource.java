package ${package}.resources;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.inject.Inject;
import ${package}.services.MessageService;

@Path("/resource")
public class MyResource {

	@Inject
	MessageService messageService;
	
	@GET
	@Path("/hello")
	public String sayHello(){
		return messageService.getMessage();
	}
	
}
