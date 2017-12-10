package au.com.liu.jiang.pnp.spring.config;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import au.com.liu.jiang.pnp.spring.greeting.services.casual.CasualGreetingService;
import au.com.liu.jiang.pnp.spring.greeting.services.formal.FormalGreetingService;
import au.com.liu.jiang.pnp.spring.plugin.spi.GreetingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GreetingServiceFactoryBeanConfig.class)
public class GreetingServiceFactoryBeanConfigTest {

	@Autowired
	private GreetingServiceFactoryBeanConfig config;
	
	@Resource(name="casual")
	private GreetingService greetingService;
	
	@Test
	public void shouldReturnCasualGreetingServiceFactory() {
		assertThat(config, is(notNullValue()));
		assertThat(config.casualGreetingService(), 
				is(instanceOf(CasualGreetingService.class)));
	}
	
	@Test
	public void shouldReturnFormalGreetingServiceFactory() {
		assertThat(config, is(notNullValue()));
		assertThat(config.formalGreetingService(), 
				is(instanceOf(FormalGreetingService.class)));
	}
	
	@Test
	public void shouldPopulateGreetingServiceAsCasual() {
		assertThat(greetingService, is(notNullValue()));
		assertThat(greetingService, is(instanceOf(CasualGreetingService.class)));
	}
	
	@Test
	public void shouldReturnCasualGreetingServiceAccordingToInput() {
		assertThat(config, is(notNullValue()));
		assertThat(config.getService("casual"),
				is(instanceOf(CasualGreetingService.class)));
	}
	
	@Test
	public void shouldReturnFormalGreetingServiceAccordingToInput() {
		assertThat(config, is(notNullValue()));
		assertThat(config.getService("formal"),
				is(instanceOf(FormalGreetingService.class)));
	}
}
