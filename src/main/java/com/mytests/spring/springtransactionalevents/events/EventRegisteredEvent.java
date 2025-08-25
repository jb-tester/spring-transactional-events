package com.mytests.spring.springtransactionalevents.events;


import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class EventRegisteredEvent extends ApplicationEvent {

    private final String message;

    public EventRegisteredEvent(Object source, Clock clock, String string) {
        super(source, clock);
        this.message = string + " occurred at " + clock;
    }
    public String getMessage() {
        return message;
    }
}
