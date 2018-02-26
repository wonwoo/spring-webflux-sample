package ml.wonwoo.springwebfluxsample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;

@Controller
public class HomeController {

    private final PersonRepository personRepository;

    public HomeController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public Rendering findAll() {
        return Rendering.view("index")
                .modelAttribute("persons", this.personRepository.findAll())
                .build();
    }

}
