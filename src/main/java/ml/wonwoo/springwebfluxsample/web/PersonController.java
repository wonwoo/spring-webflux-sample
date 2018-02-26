package ml.wonwoo.springwebfluxsample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;

import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Rendering findAll() {
        return Rendering.view("index")
                .modelAttribute("persons", this.personRepository.findAll())
                .build();
    }

    @GetMapping("/{id}")
    public Mono<Person> findById(@PathVariable String id) {
        return this.personRepository.findById(id);
    }
}
