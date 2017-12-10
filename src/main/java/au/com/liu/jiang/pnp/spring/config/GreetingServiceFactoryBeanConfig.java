package au.com.liu.jiang.pnp.spring.config;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import au.com.liu.jiang.pnp.spring.greeting.services.casual.CasualGreetingService;
import au.com.liu.jiang.pnp.spring.greeting.services.formal.FormalGreetingService;
import au.com.liu.jiang.pnp.spring.plugin.spi.GreetingService;

@Configuration
public class GreetingServiceFactoryBeanConfig {

	@Bean(name="casual")
	public GreetingService casualGreetingService() {
		return new CasualGreetingService();
	}
	
	@Bean(name="formal")
	public GreetingService formalGreetingService() {
		return new FormalGreetingService();
	}

	public GreetingService getService(final String string) {
		if (null == string || 0 == string.trim().length()) {
			throw new IllegalArgumentException("Service string cannot be blank!");
		}
		ServiceLoader<GreetingService> greetingServiceLoader = ServiceLoader.load(GreetingService.class);
		Iterator<GreetingService> greetingServices = greetingServiceLoader.iterator();
		if (!greetingServices.hasNext()) {
			throw new IllegalStateException("No GreetingService provider found");
		}
		while(greetingServices.hasNext()) {
			GreetingService greetingService = greetingServices.next();
			String serviceClassName = greetingService.getClass().getSimpleName().toLowerCase();
			if (serviceClassName.contains(string.toLowerCase())) {
				return greetingService;
			}
		}
		throw new IllegalArgumentException("Unknow Service: " + string);
	}
}
