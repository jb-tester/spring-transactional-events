package com.mytests.spring.springtransactionalevents.events;

import org.springframework.context.ApplicationEvent;


public class GroupUpdatedEvent extends ApplicationEvent {

    private final String message;

    public GroupUpdatedEvent(Object source, String lname) {
        super(source);
        this.message = lname + " group was updated";
    }
    public String getMessage() {
        return message;
    }
}
