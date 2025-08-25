package com.mytests.spring.springtransactionalevents.events;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class EventsDBService {

    private final EventsRepository repository;

    public EventsDBService(EventsRepository repository) {
        this.repository = repository;
    }

    public List<String> getAll() {
        return repository.getAllBy().stream().map(EventsEntity::toString).toList();
    }

    public void save(EventsEntity entity) {
        repository.save(entity);
    }
}