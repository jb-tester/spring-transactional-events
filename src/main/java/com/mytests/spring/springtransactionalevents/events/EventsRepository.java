package com.mytests.spring.springtransactionalevents.events;

import org.springframework.data.repository.CrudRepository;


public interface EventsRepository extends CrudRepository<EventsEntity, Integer> {


}