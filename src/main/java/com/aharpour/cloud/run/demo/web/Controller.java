package com.aharpour.cloud.run.demo.web;

import com.aharpour.cloud.run.demo.domain.Person;
import com.aharpour.cloud.run.demo.repository.PersonRepository;
import com.aharpour.cloud.run.demo.service.InstanceIdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class Controller {

    private final PersonRepository personRepository;
    private final InstanceIdService instanceIdService;

    public Controller(PersonRepository personRepository, InstanceIdService instanceIdService) {
        this.personRepository = personRepository;
        this.instanceIdService = instanceIdService;
    }

    @GetMapping("/")
    public String greet() {
        String subject = getRandomPerson()
                .map(p -> p.getName() + " " + p.getSurname())
                .orElse("World");
        return "{ \"greeting\": \"Hello " + subject + "!\", \"id\": " + instanceIdService.getId() + "}";
    }

    public Optional<Person> getRandomPerson() {
        Optional<Person> result;
        List<Person> all = personRepository.findAll();
        if (all.isEmpty()) {
            result = Optional.empty();
        } else {
            int index = ThreadLocalRandom.current().nextInt(all.size());
            result = Optional.of(all.get(index));
        }
        return result;
    }
}
