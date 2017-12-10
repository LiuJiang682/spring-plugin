package au.com.liu.jiang.pnp.spring.greeting.services.casual;

import java.text.MessageFormat;

import au.com.liu.jiang.pnp.spring.plugin.spi.GreetingService;
import au.com.liu.jiang.pnp.spring.plugin.spi.Person;

public class CasualGreetingService implements GreetingService {

	public String greet(Person person) {
		String firstname = person.getFirstname();
		String greeting = MessageFormat.format("Hello {0}", firstname);
		return greeting;
	}

}
