package com.mytests.spring.springtransactionalevents.listeners;

import com.mytests.spring.springtransactionalevents.events.*;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.Clock;


@Service
public class RegisterEventsService {

    private final EventsDBService eventsDBService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public RegisterEventsService(EventsDBService eventsDBService, ApplicationEventPublisher applicationEventPublisher) {
        this.eventsDBService = eventsDBService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @EventListener
    public void registerPersonAddedEvent(PersonAddedEvent event) {
        EventsEntity entity = new EventsEntity();
        entity.setType("PersonAddedEvent");
        String text = String.format("%s %s (%d)", event.getFname(), event.getLname(), event.getAge());
        entity.setText("Person " + text + " was added with id " + event.getId());
        entity.setCreatedAt(event.getIssued());
        eventsDBService.save(entity);
        applicationEventPublisher.publishEvent(new EventRegisteredEvent(this, Clock.systemUTC(), entity.toString()));
    }
    @EventListener
    public void registerDataBasePopulatedEvent(DataBasePopulatedEvent event) {
        EventsEntity entity = new EventsEntity();
        entity.setType("DataBasePopulatedEvent");
        entity.setText(event.getDbName() + event.getMessage() + " with " + event.getAmount() + " records");
        eventsDBService.save(entity);
        applicationEventPublisher.publishEvent(new EventRegisteredEvent(this, Clock.systemUTC(), entity.toString()));
    }
     @EventListener
    public void registerGroupUpdatedEvent(GroupUpdatedEvent event) {
        EventsEntity entity = new EventsEntity();
        entity.setType("GroupUpdatedEvent");
        entity.setText(event.getMessage());
        eventsDBService.save(entity);
        applicationEventPublisher.publishEvent(new EventRegisteredEvent(this, Clock.systemUTC(), entity.toString()));
    }
}
