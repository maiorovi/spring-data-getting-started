package mongo_example.app.repository;

import mongo_example.app.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	Customer findByFirstName(String firstName);
	List<Customer> findByLastName(String lastName);
}
