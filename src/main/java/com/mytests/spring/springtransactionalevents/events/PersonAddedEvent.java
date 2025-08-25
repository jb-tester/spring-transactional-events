package com.mytests.spring.springtransactionalevents.events;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.time.Instant;


public class PersonAddedEvent extends ApplicationEvent {
    private final String fname;
    private final String lname;
    private final int age;
    private final int id;
    private final Instant issued;

    public PersonAddedEvent(Object source, Clock clock, String fname, String lname, int age, int id) {
        super(source, clock);
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.id = id;
        this.issued = java.time.Clock.systemDefaultZone().instant();
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public Instant getIssued() {
        return issued;
    }
}
