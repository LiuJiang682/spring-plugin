package au.com.liu.jiang.pnp.spring.greeting.services.formal;

import java.util.HashMap;
import java.util.Map;

import au.com.liu.jiang.pnp.spring.plugin.spi.GreetingService;
import au.com.liu.jiang.pnp.spring.plugin.spi.Person;
import au.com.liu.jiang.pnp.spring.plugin.spi.Gender;

public class FormalGreetingService implements GreetingService {

	private Map<Gender, String> titleMap = new HashMap<Gender, String>();

	public FormalGreetingService() {
		titleMap.put(Gender.MALE, "Mr.");
		titleMap.put(Gender.FEMALE, "Ms.");
	}

	public String greet(Person person) {
		StringBuilder greetingBuilder = new StringBuilder();

		greetingBuilder.append("Dear ");

		Gender gender = person.getGender();
		String title = titleMap.get(gender);
		
		if (title != null) {
			greetingBuilder.append(title);
			greetingBuilder.append(" ");
		}

		String lastname = person.getLastname();
		greetingBuilder.append(lastname);

		String greeting = greetingBuilder.toString();
		return greeting;
	}

}
