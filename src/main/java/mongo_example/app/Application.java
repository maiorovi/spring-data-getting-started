package mongo_example.app;

import mongo_example.app.repository.CustomerRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MongoAppContextConfiguration.class);

		CustomerRepository customerRepository = applicationContext.getBean(CustomerRepository.class);

//		customerRepository.save(new Customer("Egor", "Maiorov"));

		customerRepository.findByLastName("Maiorov").forEach((cust) -> System.out.println(cust));
	}
}
