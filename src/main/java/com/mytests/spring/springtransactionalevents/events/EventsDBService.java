package com.mytests.spring.springtransactionalevents.events;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EventsDBService {

    private final EventsRepository repository;

    public EventsDBService(EventsRepository repository) {
        this.repository = repository;
    }

    public void displayAll() {
        System.out.println("====== All PersonEvents: =====");
        repository.findAll().forEach(System.out::println);
        System.out.println("===================");
    }

    public void save(EventsEntity entity) {
        repository.save(entity);
    }
}