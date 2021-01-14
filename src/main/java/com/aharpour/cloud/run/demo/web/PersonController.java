package com.aharpour.cloud.run.demo.web;

import com.aharpour.cloud.run.demo.domain.Person;
import com.aharpour.cloud.run.demo.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person) {
        if (person.getId() != null) {
            throw new IllegalArgumentException("A new person should not have an id.");
        }
        return repository.save(person);
    }

}
