package jpa_example.app.repository;

import jpa_example.app.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer ,Long> {
}
