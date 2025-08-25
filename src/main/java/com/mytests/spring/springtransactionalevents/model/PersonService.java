package com.mytests.spring.springtransactionalevents.model;

import com.mytests.spring.springtransactionalevents.events.DataBasePopulatedEvent;
import com.mytests.spring.springtransactionalevents.events.PersonAddedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.util.List;


@Service
public class PersonService {

    private final PersonRepository repository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final GroupService groupService;

    public PersonService(PersonRepository repository, ApplicationEventPublisher applicationEventPublisher, GroupService groupService) {
        this.repository = repository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.groupService = groupService;
    }

    public List<String> getAll() {
        return repository.findAll().stream().map(Person::toString).toList();
    }

    @Transactional
    public Person savePerson(Person person) {
        Person p = repository.save(person);
        applicationEventPublisher.publishEvent(new PersonAddedEvent(this, Clock.systemUTC(), p.getFirstName(), p.getLastName(), p.getAge(), p.getId() ));
        return person;
    }

    @Transactional
    public void populateDB() {
        repository.save(new Person("Ivan", "Ivanov", 10));
        repository.save(new Person("Petr", "Petrov", 20));
        repository.save(new Person("Pavel", "Pavlov", 30));
        groupService.saveGroup(new Group("Ivanov", "Ivanovs group", "1"));
        groupService.saveGroup(new Group("Petrov", "Petrovs group", "1"));
        groupService.saveGroup(new Group("Pavlov", "Pavlovs group", "1"));
        applicationEventPublisher.publishEvent(new DataBasePopulatedEvent(this, 3, "person", "DB was populated"));
    }

}