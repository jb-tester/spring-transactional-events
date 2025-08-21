package com.mytests.spring.springtransactionalevents.events;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.time.Instant;


public class PersonAddedEvent extends ApplicationEvent {
    private final String txt;
    private final int id;
    private final Instant issued;

    public PersonAddedEvent(Object source, Clock clock, String txt, int id) {
        super(source, clock);
        this.txt = txt;
        this.id = id;
        this.issued = java.time.Clock.systemDefaultZone().instant();
    }

    public String getTxt() {
        return txt;
    }

    public int getId() {
        return id;
    }

    public Instant getIssued() {
        return issued;
    }
}
