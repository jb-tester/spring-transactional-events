package com.mytests.spring.springtransactionalevents.listeners;

import com.mytests.spring.springtransactionalevents.events.DataBasePopulatedEvent;
import com.mytests.spring.springtransactionalevents.events.PersonAddedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
public class LogEventsService {

    @EventListener
    public void logPersonAddedEvent(PersonAddedEvent event) {
        System.out.println("====== PersonAddedEvent: " + event.toString() + " =====");
    }

    @EventListener
    public void logDataBasePopulatedEvent(DataBasePopulatedEvent event) {
        System.out.println("====== DataBasePopulatedEvent: " + event.toString() + " =====");
    }
}
