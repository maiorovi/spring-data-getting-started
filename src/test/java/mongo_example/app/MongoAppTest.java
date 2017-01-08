package mongo_example.app;

import mongo_example.app.domain.Customer;
import mongo_example.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import java.util.Collection;
import java.util.List;

@ContextConfiguration(classes = MongoAppContextConfiguration.class)
public class MongoAppTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void findCustomersByLastName() throws Exception {
		List<Customer> customers = customerRepository.findByLastName("Maiorov");
	}
}
