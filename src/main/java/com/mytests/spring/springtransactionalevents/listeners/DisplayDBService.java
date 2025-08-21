package com.mytests.spring.springtransactionalevents.listeners;

import com.mytests.spring.springtransactionalevents.events.DataBasePopulatedEvent;
import com.mytests.spring.springtransactionalevents.events.PersonAddedEvent;
import com.mytests.spring.springtransactionalevents.model.PersonService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DisplayDBService {

    private final PersonService personService;

    public DisplayDBService(PersonService personService) {
        this.personService = personService;
    }

    @EventListener
    public void afterPersonAddedEvent(PersonAddedEvent event) {
        System.out.println("===== resulted DB: ====");
        personService.getAll().forEach(System.out::println);
        System.out.println("=======================");
    }

    @EventListener
    public void afterDataBasePopulatedEvent(DataBasePopulatedEvent event) {
        System.out.println("===== resulted DB: ====");
        List<String> all = personService.getAll();
        all.forEach(System.out::println);
        System.out.println("=======================");
    }
}
