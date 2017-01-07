package mongo_example.app;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

@Configuration
@ComponentScan
@EnableMongoRepositories(basePackages = {"mongo_example.app.repository"})
@PropertySource(value = "mongo.properties")
public class MongoAppContextConfiguration {

	@Autowired
	Environment env;

	@Bean
	public MongoClient mongoClient() throws UnknownHostException {
		MongoClient mongoClient = new MongoClient(env.getProperty("mongo.host"), Integer.parseInt(env.getProperty("mongo.port")));

		return mongoClient;
	}

	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException {
		return new MongoTemplate(mongoClient(), "spring_data_test");
	}

}
