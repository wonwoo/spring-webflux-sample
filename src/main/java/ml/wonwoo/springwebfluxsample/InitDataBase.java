package ml.wonwoo.springwebfluxsample;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ml.wonwoo.springwebfluxsample.web.Person;
import ml.wonwoo.springwebfluxsample.web.PersonRepository;

@Component
public class InitDataBase implements CommandLineRunner {

    private final PersonRepository personRepository;

    public InitDataBase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) {
        List<Person> persons = Arrays.asList(new Person("wonwoo", "lee"), new Person("kevin", "lee"));
        this.personRepository.deleteAll()
                .thenMany(this.personRepository.saveAll(persons))
                .subscribe(null, null,
                        () -> this.personRepository.findAll().subscribe(System.out::println));
    }
}
