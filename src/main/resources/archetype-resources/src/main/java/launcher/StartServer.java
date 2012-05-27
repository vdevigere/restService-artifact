package ${package}.launcher;

import java.io.File;

import org.glassfish.embeddable.Deployer;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;

public class StartServer {

	public static void main(String[] args) throws GlassFishException {
		GlassFishProperties gfProps = new GlassFishProperties();
		String sPort = System.getenv("PORT");
		if (sPort != null) {
			gfProps.setPort("http-listener", Integer.valueOf(sPort));
		} else {
			gfProps.setPort("http-listener", 8080);
		}
		GlassFish glassfish = GlassFishRuntime.bootstrap().newGlassFish(gfProps);
		glassfish.start();

		// Deploy .WAR file
		Deployer deployer = glassfish.getDeployer();
		deployer.deploy(new File("target/${artifactId}-${version}.war")); 
	}

}
