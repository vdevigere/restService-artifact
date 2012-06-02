package ${package}.config;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;


public class PersistenceModule extends ServletModule{

	@Override
	protected void configureServlets() {
		install(new JpaPersistModule("testPU"));
		filter("/*").through(PersistFilter.class);
	}
}
