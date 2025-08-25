package com.mytests.spring.springtransactionalevents.events;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;


public interface EventsRepository extends CrudRepository<EventsEntity, Integer> {


   List<EventsEntity> getAllBy();
}