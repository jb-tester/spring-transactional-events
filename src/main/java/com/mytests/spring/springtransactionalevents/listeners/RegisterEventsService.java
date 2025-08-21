package com.mytests.spring.springtransactionalevents.listeners;

import com.mytests.spring.springtransactionalevents.events.DataBasePopulatedEvent;
import com.mytests.spring.springtransactionalevents.events.EventsDBService;
import com.mytests.spring.springtransactionalevents.events.EventsEntity;
import com.mytests.spring.springtransactionalevents.events.PersonAddedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
public class RegisterEventsService {

    private final EventsDBService eventsDBService;

    public RegisterEventsService(EventsDBService eventsDBService) {
        this.eventsDBService = eventsDBService;
    }

    @EventListener
    public void registerPersonAddedEvent(PersonAddedEvent event) {
        EventsEntity entity = new EventsEntity();
        entity.setType("PersonAddedEvent");
        entity.setText("Person " + event.getTxt() + " was added with id " + event.getId());
        entity.setCreatedAt(event.getIssued());
        eventsDBService.save(entity);
    }
    @EventListener
    public void registerDataBasePopulatedEvent(DataBasePopulatedEvent event) {
        EventsEntity entity = new EventsEntity();
        entity.setType("DataBasePopulatedEvent");
        entity.setText(event.getDbName() + event.getMessage() + " with " + event.getAmount() + " records");
        eventsDBService.save(entity);
    }
}
