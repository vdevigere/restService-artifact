package ${package}.config;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import ${package}.resources.MyResource;
import ${package}.services.HelloWorldMessageService;
import ${package}.services.MessageService;


public class JerseyModule extends ServletModule{

	@Override
	protected void configureServlets() {
		//TODO: Add bindings here...
		
		bind(MyResource.class);
		bind(MessageService.class).to(HelloWorldMessageService.class);
		
		serve("/*").with(GuiceContainer.class);
	}
}
