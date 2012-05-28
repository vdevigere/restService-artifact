package ${package}.launcher;

import java.io.File;
import java.io.IOException;

import org.glassfish.embeddable.Deployer;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;
import org.glassfish.embeddable.archive.ScatteredArchive;

public class StartServer {

	public static void main(String[] args) throws GlassFishException, IOException {
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
		
//		ScatteredArchive archive = new ScatteredArchive("${artifactId}", ScatteredArchive.Type.WAR);
//		archive.addClassPath(new File("target", "classes"));
//		archive.addMetadata(new File("src/main/webapp/WEB-INF", "web.xml"));
//		deployer.deploy(archive.toURI());
		
		deployer.deploy(new File("target/${artifactId}-${version}.war")); 
	}

}
