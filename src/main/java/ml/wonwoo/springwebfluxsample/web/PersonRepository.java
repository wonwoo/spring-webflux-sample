package ml.wonwoo.springwebfluxsample.web;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonRepository extends ReactiveMongoRepository<Person, String>{

}
