package ${package}.config;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import ${package}.resources.MyMessageResource;
import ${package}.persister.MessagePersister;


public class JerseyModule extends ServletModule{

	@Override
	protected void configureServlets() {
		//TODO: Add bindings here...
		
		bind(MyMessageResource.class);
		bind(MessagePersister.class);
		
		serve("/*").with(GuiceContainer.class);
	}
}
