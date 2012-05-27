package ${package}.services;

public class HelloWorldMessageService implements MessageService {
	private static final String HELLO_WORLD = "Hello World";


	public String getMessage() {
		return HELLO_WORLD;
	}

}
