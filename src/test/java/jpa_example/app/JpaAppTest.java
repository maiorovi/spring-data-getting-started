package jpa_example.app;

import jpa_example.app.domain.Customer;
import jpa_example.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(classes = {JpaContext.class})
public class JpaAppTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void testName() throws Exception {
		Customer customer = new Customer("Egor", "Maiorov", 26);
		customerRepository.save(customer);
	}
}
