package com.mytests.spring.springtransactionalevents.listeners;

import com.mytests.spring.springtransactionalevents.events.*;
import com.mytests.spring.springtransactionalevents.model.GroupService;
import com.mytests.spring.springtransactionalevents.model.PersonService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DisplayDBService {

    private final PersonService personService;
    private final EventsDBService eventsDBService;
    private final GroupService groupService;

    public DisplayDBService(PersonService personService, EventsDBService eventsDBService, GroupService groupService) {
        this.personService = personService;
        this.eventsDBService = eventsDBService;
        this.groupService = groupService;
    }

    @EventListener
    public void afterPersonAddedEvent(PersonAddedEvent event) {
        System.out.println("===== resulted Person DB: ====");
        personService.getAll().forEach(System.out::println);
        System.out.println("=======================");
    }

    @EventListener
    public void afterDataBasePopulatedEvent(DataBasePopulatedEvent event) {
        System.out.println("===== resulted Person DB: ====");
        List<String> all = personService.getAll();
        all.forEach(System.out::println);
        System.out.println("=======================");
    }
    @EventListener
    public void afterGroupUpdatedEvent(GroupUpdatedEvent event) {
        System.out.println("===== resulted Group DB: ====");
        groupService.displayAll();
        System.out.println("=======================");
    }
    @EventListener
    public void afterEventRegisteredEvent(EventRegisteredEvent event) {
        System.out.println("===== resulted Events DB: ====");
        List<String> all = eventsDBService.getAll();
        all.forEach(System.out::println);
    }
}
