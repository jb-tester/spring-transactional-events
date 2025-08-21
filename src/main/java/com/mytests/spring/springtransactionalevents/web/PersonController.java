package com.mytests.spring.springtransactionalevents.web;

import com.mytests.spring.springtransactionalevents.model.Person;
import com.mytests.spring.springtransactionalevents.model.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * *
 * <p>Created by Irina on 8/21/2025.</p>
 * *
 */
@RestController
@RequestMapping("/")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public List<String> all() {
        return personService.getAll();
    }
    @PostMapping("/add")
    public Person add(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PostMapping("/addByParams")
    public Person addByParams(@RequestParam("fname") String fname, @RequestParam("lname") String lname, @RequestParam("age") int age) {
        return personService.savePerson(new Person(fname,lname, age));
    }
}
