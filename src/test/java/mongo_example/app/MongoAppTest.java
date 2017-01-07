package mongo_example.app;

import mongo_example.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = MongoAppContextConfiguration.class)
public class MongoAppTest {

	@Autowired
	private CustomerRepository customerRepository;




}
